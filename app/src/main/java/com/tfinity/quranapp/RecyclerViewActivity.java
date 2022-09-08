package com.tfinity.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        DBHelper db=new DBHelper(RecyclerViewActivity.this);
        ArrayList<DataModel> ListViewArray=db.getdata();
        RecyclerView recyclerView;

        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(RecyclerViewActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent=getIntent();

        adapter = new RecyclerViewAdapter(ListViewArray,intent.getStringExtra("name"));
        recyclerView.setAdapter(adapter);
    }
}