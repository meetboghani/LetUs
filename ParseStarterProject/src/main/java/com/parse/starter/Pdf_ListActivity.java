package com.parse.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Pdf_ListActivity extends AppCompatActivity {

    TextView title;
    ListView myListView;

    public void fetchData(String s){
        final ArrayList<String> Contents = new ArrayList<String>();
        final ArrayList<String> ObjectId = new ArrayList<>();
        title.setText(s);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("PendingReqs");
        query.whereEqualTo("Type", s);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Contents.add(object.getString("Topic"));
                            ObjectId.add(object.getObjectId());
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Pdf_ListActivity.this, android.R.layout.simple_list_item_1,Contents);
                        myListView.setAdapter(arrayAdapter);

                        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent=new Intent(Pdf_ListActivity.this,itemDetailActivity.class);
                                intent.putExtra("ObjectId",ObjectId.get(i));
                                startActivity(intent);

                            }
                        });

                    }else {
                        Log.i("Failure","Array null");
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf__list);
        myListView = findViewById(R.id.myListView);
        title=findViewById(R.id.title_lv);
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();

        if(bundle!=null)
        {
            String s =(String)bundle.getString("type");
            fetchData(s);
            Log.i("Success","done");

        }
        else {
            Log.i("Failed","empty string");
        }




        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }
}