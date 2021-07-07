package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class userReqActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    String store;
    private static final String[] paths = {"Video making/editing", "Science Project", "Pdf file","Album Making"};
    EditText Topic;
    EditText Des;


    public  void openList(View view){
        Intent intent=new Intent(userReqActivity.this,Home_server_Activity.class);
        startActivity(intent);
    }

    public void postInfo(View view){
        ParseObject object=new ParseObject("PendingReqs");
        object.put("username", ParseUser.getCurrentUser().getUsername());
        object.put("Type",store);
        object.put("Topic",Topic.getText().toString());
        object.put("Desc",Des.getText().toString());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Log.i("Success","Saved");

                }else {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_req);

        spinner = (Spinner)findViewById(R.id.spinner);
        Topic=findViewById(R.id.topicName_et);
        Des=findViewById(R.id.desc_Et);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(userReqActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                store="Video making/editing"; // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                store="Science Project";
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                store="Pdf file";
                // Whatever you want to happen when the thrid item gets selected
                break;
            case 3:
                store="Album Making";
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
        store="Video making/editing";
    }

}
