package com.parse.starter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class serverLoginActivity extends AppCompatActivity  {
    int i=0;

    TextInputEditText username;
    TextInputEditText password;

    public void SignUpUser(View view){
        {

            Intent intent=new Intent(serverLoginActivity.this,serSignupActivity.class);
            startActivity(intent);
        }
    }

    public void loginUser(View view){

        if(username.getText().toString().matches("") && password.getText().toString().matches("")){

            Toast.makeText(this,"UserName and Password are required",Toast.LENGTH_SHORT).show();
        }
        else {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Helpinguser");
            query.whereEqualTo("username",username.getText().toString());
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e==null) {
                        if (objects.size() > 0) {
                            for (ParseObject object : objects) {
                                if (object.getString("password").matches(password.getText().toString())) {
                                    Intent intent = new Intent(serverLoginActivity.this, Home_server_Activity.class);
                                    startActivity(intent);
                                    i = 1;

                                }

                            }
                            if (i != 1) {
                                Toast.makeText(serverLoginActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serverLoginActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        e.printStackTrace();

                    }
                }
            });

            }

        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    }
}