package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    Button btn;
    public void HelperLogin(View view){

        Intent intent=new Intent(SelectActivity.this,serverLoginActivity.class);
        startActivity(intent);
    }

    public void userLogin(View view) {
        Intent intent = new Intent(SelectActivity.this, loginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btn=findViewById(R.id.userbutton);
    }
}