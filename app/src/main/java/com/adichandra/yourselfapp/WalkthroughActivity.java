package com.adichandra.yourselfapp;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 12/05/2021
 * Deskripsi : Membuat kondisi SharedPreferences dan membuat fungsi onClick
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.navigation.NavigationView;

public class WalkthroughActivity extends AppCompatActivity {

    //Kunci string boolean pengguna baru/bukan
    private static final String FIRST_USER = "firstTime";

    LiquidPager pager;
    ViewPager viewPager;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        preferences = getSharedPreferences("myPref",MODE_PRIVATE);

        getPrefData();
        savePrefData();
    }

    public void getPrefData() {
        if (preferences.getBoolean(FIRST_USER,false)){
            Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
            startActivity(intent);
        }
    }


    private void savePrefData() {
        preferences.edit().putBoolean(FIRST_USER, true).apply();
    }

    public void btnGo(View view) {
        savePrefData();
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnSkip(View view) {
        savePrefData();
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }
}