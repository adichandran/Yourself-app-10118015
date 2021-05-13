package com.adichandra.yourselfapp;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 12/05/2021
 * Deskripsi : Membuat Tampilan WalkthroughActivity dengan 3 Frament
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cuberto.liquid_swipe.LiquidPager;

public class WalkthroughActivity extends AppCompatActivity {

    LiquidPager pager;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);
    }
}