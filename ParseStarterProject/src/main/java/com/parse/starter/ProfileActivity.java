package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ProfileActivity extends AppCompatActivity {

    String[] cols={"FullName","email","MobileNumber","City"};

    TextInputEditText Name;
    TextInputEditText Email;
    TextInputEditText Number;
    TextInputEditText City;
    TextView Username_tv;
    TextView username_user;

    public void UpdateUser(View view){
        Toast.makeText(ProfileActivity.this,"Button Pressed",Toast.LENGTH_SHORT).show();

         updateName();
         updateMail();
         updateNumber();
         updateCity();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Name=findViewById(R.id.Name_fetch);
        Email=findViewById(R.id.Email_Fetch);
        Number=findViewById(R.id.Mobile_fetch);
        City=findViewById(R.id.City_fetch);
        Username_tv=findViewById(R.id.username_Tv);
        username_user=findViewById(R.id.username_user);

        fetchInfo();
    }

    private void fetchInfo() {
        Username_tv.setText(ParseUser.getCurrentUser().get("FullName").toString());
        username_user.setText(ParseUser.getCurrentUser().get("username").toString());
        Number.setText(ParseUser.getCurrentUser().get("MobileNumber").toString());
        Email.setText(ParseUser.getCurrentUser().getEmail());
        Name.setText(ParseUser.getCurrentUser().get("FullName").toString());
        City.setText(ParseUser.getCurrentUser().get("City").toString());

    }
    private void updateName(){
        ParseQuery<ParseObject> query= ParseQuery.getQuery(ParseUser.getCurrentUser().getClassName());
        query.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object!= null) {

                    object.put(cols[0], Name.getText().toString());
                    object.saveInBackground();
                }

                else {
                    e.printStackTrace();
                }
            }
        });
    }

    private void updateMail(){
        ParseQuery<ParseObject> query= ParseQuery.getQuery(ParseUser.getCurrentUser().getClassName());
        query.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object!= null) {

                    object.put(cols[1], Email.getText().toString());
                    object.saveInBackground();
                }

                else {
                    e.printStackTrace();
                }
            }
        });
    }


    private void updateNumber(){
        ParseQuery<ParseObject> query= ParseQuery.getQuery(ParseUser.getCurrentUser().getClassName());
        query.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object!= null) {

                    object.put(cols[2], Number.getText().toString());
                    object.saveInBackground();
                }

                else {
                    e.printStackTrace();
                }
            }
        });
    }


    private void updateCity(){
        ParseQuery<ParseObject> query= ParseQuery.getQuery(ParseUser.getCurrentUser().getClassName());
        query.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null && object!= null) {

                    object.put(cols[3], City.getText().toString());
                    object.saveInBackground();
                }

                else {
                    e.printStackTrace();
                }
            }
        });
    }
}