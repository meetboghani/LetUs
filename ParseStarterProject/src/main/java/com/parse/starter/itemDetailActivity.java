package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class itemDetailActivity extends AppCompatActivity {
    TextView Type;
    TextView Topic;
    TextView Desc;
    TextView Title_Page;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Type=findViewById(R.id.type_Fetch);
        Topic=findViewById(R.id.topicName_fetch);
        Desc=findViewById(R.id.desc_fetch);
        Title_Page=findViewById(R.id.page_Title);


        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        {
             s =(String)bundle.getString("ObjectId");


            Log.i("Success","done");

        }
        ParseQuery<ParseObject> query=ParseQuery.getQuery("PendingReqs");
        query.getInBackground(s, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {

                Type.setText(object.getString("Type"));
                Topic.setText(object.getString("Topic"));
                Desc.setText(object.getString("Desc"));
                Title_Page.setText(object.getString("username")+"'s Request");

            }
        });
    }
}