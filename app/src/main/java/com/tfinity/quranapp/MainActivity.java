package com.tfinity.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    CardView start, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        start=findViewById(R.id.startRead);
        setting=findViewById(R.id.Setting);


        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.read:
                        intent=new Intent(MainActivity.this,Read.class);
                        startActivity(intent);
                        break;
                    case R.id.fatehMuhammad:
                        intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
                        intent.putExtra("name","fatehMuhammad");
                        startActivity(intent);
                        break;
                    case R.id.mehmoodUlHassan:
                        intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
                        intent.putExtra("name","mehmoodUlHassan");
                        startActivity(intent);
                        break;
                    case R.id.drMohsin:
                        intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
                        intent.putExtra("name","drMohsin");
                        startActivity(intent);
                        break;
                    case R.id.muftiTaqi:
                        intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
                        intent.putExtra("name","muftiTaqi");
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });


        setupOnClick();
    }
    void setupOnClick(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Read.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
            }
        });
    }
}