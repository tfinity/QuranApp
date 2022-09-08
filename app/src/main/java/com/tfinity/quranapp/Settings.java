package com.tfinity.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Switch fateMuhammad, mehmoodHassan,noUrdu,mohsinKhan,taqiUsmani,noEnglish;
    Button save;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences("prefs", Context.MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        setContentView(R.layout.activity_settings);




        fateMuhammad=findViewById(R.id.FateMuhammadSwitch);
        mehmoodHassan=findViewById(R.id.mehmoodHassanSwitch);
        noUrdu=findViewById(R.id.noUrduSwitch);
        mohsinKhan=findViewById(R.id.mohsinKhanSwitch);
        taqiUsmani=findViewById(R.id.taqiUsmaniSwitch);
        noEnglish=findViewById(R.id.noEnglishSwitch);
        save=findViewById(R.id.save);
        getCheckStatus();
        fateMuhammad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mehmoodHassan.setChecked(false);
                noUrdu.setChecked(false);
                myEdit.putInt("Urdu",1);
            }
        });
        mehmoodHassan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fateMuhammad.setChecked(false);
                noUrdu.setChecked(false);
                myEdit.putInt("Urdu",2);
            }
        });
        noUrdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mehmoodHassan.setChecked(false);
                fateMuhammad.setChecked(false);
                myEdit.putInt("Urdu",3);
            }
        });

        mohsinKhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taqiUsmani.setChecked(false);
                noEnglish.setChecked(false);
                myEdit.putInt("English",1);
            }
        });
        taqiUsmani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mohsinKhan.setChecked(false);
                noEnglish.setChecked(false);
                myEdit.putInt("English",2);
            }
        });
        noEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taqiUsmani.setChecked(false);
                mohsinKhan.setChecked(false);
                myEdit.putInt("English",3);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEdit.commit();
                finish();
            }
        });



    }
    void getCheckStatus(){
        int urdu= sharedPreferences.getInt("Urdu",-1);
        int english=sharedPreferences.getInt("English",-1);
        if(urdu==1){
            fateMuhammad.setChecked(true);
            mehmoodHassan.setChecked(false);
            noUrdu.setChecked(false);
        }
        else if(urdu==2){
            fateMuhammad.setChecked(false);
            mehmoodHassan.setChecked(true);
            noUrdu.setChecked(false);
        }
        else if(urdu==3){
            fateMuhammad.setChecked(false);
            mehmoodHassan.setChecked(false);
            noUrdu.setChecked(true);
        }
        else{
            fateMuhammad.setChecked(false);
            mehmoodHassan.setChecked(false);
            noUrdu.setChecked(false);
        }

        if(english==1){
            mohsinKhan.setChecked(true);
            taqiUsmani.setChecked(false);
            noEnglish.setChecked(false);
        }
        else if(english==2){
            mohsinKhan.setChecked(false);
            taqiUsmani.setChecked(true);
            noEnglish.setChecked(false);
        }
        else if(english==3){
            mohsinKhan.setChecked(false);
            taqiUsmani.setChecked(false);
            noEnglish.setChecked(true);
        }
        else{
            mohsinKhan.setChecked(false);
            taqiUsmani.setChecked(false);
            noEnglish.setChecked(false);
        }
    }
}