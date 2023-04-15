package com.example.navigation_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.nav_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle draw_toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(draw_toggle);
        draw_toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.homepage_nav);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homepage_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomeFragment.class,null).commit();
                break;

            case R.id.character_pick:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, CharacterFragment.class,null).commit();
                break;

            case R.id.ambience_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, AmbienceFragment.class,null).commit();
                break;

            case R.id.to_do_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, TodolistFragment.class,null).commit();
                break;

            case R.id.database_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ProgressFragment.class,null).commit();
                break;

            case R.id.settings_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SettingsFragment.class,null).commit();
                break;

            case R.id.tutorial_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, TutorialFragment.class,null).commit();
                break;

            case R.id.logout_nav:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
