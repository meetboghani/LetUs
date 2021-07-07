package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText username;
    TextInputEditText emailid;
    TextInputEditText Number;
    TextInputEditText password;
    TextInputEditText state;
    TextInputEditText city;
    TextInputEditText Name;


    Button register;

    public void registerUser(View view){

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
        else {

            ParseUser user=new ParseUser();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.setEmail(emailid.getText().toString());
            user.put("FullName",Name.getText().toString());
            user.put("MobileNumber",Number.getText().toString());
            user.put("State",state.getText().toString());
            user.put("City",city.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){

                        Intent intent=new Intent(SignUpActivity.this,afterLogin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }

    }

    public void ToLogin(View view){
        Intent intent=new Intent(SignUpActivity.this,loginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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