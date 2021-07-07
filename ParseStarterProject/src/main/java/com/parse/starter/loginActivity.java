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
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class loginActivity extends AppCompatActivity  {

    TextInputEditText username;
    TextInputEditText password;

    public void SignUpUser(View view){
        {

            Intent intent=new Intent(loginActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }

    public void loginUser(View view){
        if(username.getText().toString().matches("")&& password.getText().toString().matches("")){

            Toast.makeText(this,"UserName and Password are required",Toast.LENGTH_SHORT).show();
        }
        else {
            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e==null){
                        Intent intent=new Intent(loginActivity.this,afterLogin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(loginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(loginActivity.this,SelectActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

    }
}
