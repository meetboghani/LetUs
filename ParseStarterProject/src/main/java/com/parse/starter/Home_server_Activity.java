package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_server_Activity extends AppCompatActivity {
    CardView cd1;
    CardView cd2;
    CardView cd3;
    CardView cd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_server_);
        cd1=findViewById(R.id.cd1);
        cd2=findViewById(R.id.cd2);
        cd3=findViewById(R.id.cd3);
        cd4=findViewById(R.id.cd4);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_server_Activity.this,Pdf_ListActivity.class);
                intent.putExtra("type","Pdf file");
                startActivity(intent);

            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_server_Activity.this,Pdf_ListActivity.class);
                intent.putExtra("type","Video making/editing");
                startActivity(intent);


            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_server_Activity.this,Pdf_ListActivity.class);
                intent.putExtra("type","Album Making");
                startActivity(intent);


            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_server_Activity.this,Pdf_ListActivity.class);
                intent.putExtra("type","Science Project");
                startActivity(intent);


            }
        });
    }
}