package com.adichandra.yourselfapp;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 12/05/2021
 * Deskripsi : Membuat Tampilan WalkthroughActivity dengan 3 Frament
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.navigation.NavigationView;

public class WalkthroughActivity extends AppCompatActivity {

    LiquidPager pager;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restorePrefData()){
            Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_walkthrough);
        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        savePrefData();
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        return pref.getBoolean("isIntroOpened",false);
    }

    private void savePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    public void btnGo(View view) {
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        savePrefData();
        finish();
    }

    public void btnSkip(View view) {
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        savePrefData();
        finish();
    }
}