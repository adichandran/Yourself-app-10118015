package com.adichandra.yourselfapp;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 12/05/2021
 * Deskripsi : Membuat Tampilan MainActivity menjadi Splash Layout
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img = findViewById(R.id.logo);
        TextView textView = findViewById(R.id.appname);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        textView.startAnimation(animation);
        img.startAnimation(animation);

        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(3000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, WalkthroughActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}