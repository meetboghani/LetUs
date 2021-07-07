package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class serSignupActivity extends AppCompatActivity {
    int i=0;
    int j=0;
    int k=0;
    String s="";
    String h="";
    String l="";

    TextInputEditText username;
    TextInputEditText emailid;
    TextInputEditText Number;
    TextInputEditText password;
    TextInputEditText state;
    TextInputEditText city;
    TextInputEditText Name;


    Button register;

    public void registerUser(View view){


        ParseQuery<ParseObject> query=ParseQuery.getQuery("Helpinguser");
        ParseQuery<ParseObject> q2=ParseQuery.getQuery("Helpinguser");
        ParseQuery<ParseObject> q3=ParseQuery.getQuery("Helpinguser");


        if(Name.getText().toString().length()==0){
            Name.setError("Pls Enter The Name");
            Name.requestFocus();
        }

        if(username.getText().toString().length()==0){
            username.setError("Pls Enter The Username");
            username.requestFocus();
        }
        if(emailid.getText().toString().length()==0){
            emailid.setError("Pls enter Email");
            emailid.requestFocus();
        }
        if(Number.getText().toString().length()==0 ){
            Number.setError("Pls enter Mobile Number");
            Number.requestFocus();
        }
        if(password.getText().toString().length()==0) {
            password.setError("Please Enter password");
            password.requestFocus();
        }
        if(password.getText().toString().length()<8) {
            password.setError("Password should be atleast of 8 charactors");
            password.requestFocus();
        }




        if(state.getText().toString().length()==0){
            state.setError("Pls enter the state");
            state.requestFocus();
        }
        if(city.getText().toString().length()==0){
            city.setError("pls enter the city");
            city.requestFocus();
        }



        if(username.getText().toString().matches("")&& password.getText().toString().matches("")){

            Toast.makeText(this,"UserName and Password are required",Toast.LENGTH_SHORT).show();
        }
        if(!username.getText().toString().equals(s) || i==0){
            s=username.getText().toString();
            query.whereEqualTo("username", username.getText().toString());
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {

                            username.setError("Username Already taken");
                            username.requestFocus();
                            i = 0;

                        } else {
                            i = 1;
                        }
                    } else {
                        e.printStackTrace();
                    }
                }
            });
        }

        if(!emailid.getText().toString().equals(h) || j==0) {
            h=emailid.getText().toString();
            q2.whereEqualTo("Email", emailid.getText().toString());
            q2.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {

                            emailid.setError("Account already exist with this Mobile Number");
                            emailid.requestFocus();
                            j = 0;

                        } else {
                            j = 1;
                        }
                    } else {
                        e.printStackTrace();

                    }
                }
            });
        }

        if(!Number.getText().toString().equals(l) || k==0) {
            l=Number.getText().toString();
            q3.whereEqualTo("MobileNumber", Number.getText().toString());
            q3.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {

                            Number.setError("Account already exist with this MobilE Number");
                            Number.requestFocus();
                            k = 0;
                        } else {
                            k = 1;
                        }
                    } else {
                        e.printStackTrace();
                    }
                }
            });
        }


        if(i==1 && j==1 && k==1) {


            ParseObject Helpinguser = new ParseObject("Helpinguser");
            Helpinguser.put("username", username.getText().toString());
            Helpinguser.put("password", password.getText().toString());
            Helpinguser.put("Email", emailid.getText().toString());
            Helpinguser.put("FullName", Name.getText().toString());
            Helpinguser.put("MobileNumber", Number.getText().toString());
            Helpinguser.put("State", state.getText().toString());
            Helpinguser.put("City", city.getText().toString());

            Helpinguser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        Intent intent=new Intent(serSignupActivity.this,Home_server_Activity.class);
                        startActivity(intent);
                    }
                    else {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    public void ToLogin(View view){
        Intent intent=new Intent(serSignupActivity.this,serverLoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ser_signup);
        username=findViewById(R.id.SignupUsername);
        password=findViewById(R.id.SignUpPassword);
        register=findViewById(R.id.RegisterButton);
        emailid=findViewById(R.id.emailid);
        Number=findViewById(R.id.MoNumber);
        state=findViewById(R.id.state);
        city=findViewById(R.id.city);
        Name=findViewById(R.id.NameFull);



    }
}

