package com.adichandra.yourselfapp;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 21/05/2021
 * Deskripsi : Membuat NavigationActivity dengan 5 Frament
 * */

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.adichandra.yourselfapp.fragment.navigation.FragmentDaily;
import com.adichandra.yourselfapp.fragment.navigation.FragmentGallery;
import com.adichandra.yourselfapp.fragment.navigation.FragmentHome;
import com.adichandra.yourselfapp.fragment.navigation.FragmentMusic;
import com.adichandra.yourselfapp.fragment.navigation.FragmentProfile;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class NavigationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(null);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Fragment fragment = null;
                switch (id){
                    case R.id.home_nav:
                        fragment = new FragmentHome();
                        loadFragment(fragment);
                        break;
                    case R.id.daily:
                        fragment = new FragmentDaily();
                        loadFragment(fragment);
                        break;
                    case R.id.gallery:
                        fragment = new FragmentGallery();
                        loadFragment(fragment);
                        break;
                    case R.id.music:
                        fragment = new FragmentMusic();
                        loadFragment(fragment);
                        break;
                    case R.id.profile:
                        fragment = new FragmentProfile();
                        loadFragment(fragment);
                        break;
                    default:
                        fragment = null;
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        if (fragment == null) {
            fragmentTransaction.add(R.id.frame, new FragmentHome());
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.replace(R.id.frame,fragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
            fragmentTransaction.addToBackStack(null);
        }

    }
}