package com.tfinity.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Read extends AppCompatActivity {
    ListView readListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        readListView=findViewById(R.id.readListView);
        DBHelper db=new DBHelper(Read.this);
        ArrayList<DataModel> ListViewArray=db.getdata();
        DataAdapter adapter=new DataAdapter(Read.this,ListViewArray);
        readListView.findViewById(R.id.readListView);
        readListView.setAdapter(adapter);
    }
}