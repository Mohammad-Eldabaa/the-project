package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ConstraintLayout con1,con2,con3,con4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_draw_open, R.string.nav_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        animate();

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    public void Onclic_aid(View view)
    {

        Intent intent = new Intent(this, First_aid_activity.class);
        startActivity(intent);
    }

    public void Onclic_call(View view)
    {
        Intent intent = new Intent(this, Call.class);
        startActivity(intent);
    }
    public void Onclic_med(View view)
    {
        Intent intent = new Intent(this, medical_acitivty.class);
        startActivity(intent);
    }

    public void Onclic_doc(View view)
    {
        Intent intent = new Intent(this, doctors_partions.class);
        startActivity(intent);
    }


    public void animate()
    {

        con1 = findViewById(R.id.con1);
        con2 = findViewById(R.id.con2);
        con3 = findViewById(R.id.con3);
        con4 = findViewById(R.id.con4);
        textView = findViewById(R.id.interface_textView);

        con2.setScaleX(0);
        con2.setScaleY(0);
        con2.setAlpha(0);
        con2.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con3.setScaleX(0);
        con3.setScaleY(0);
        con3.setAlpha(0);
        con3.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con1.setScaleX(0);
        con1.setScaleY(0);
        con1.setAlpha(0);
        con1.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con4.setScaleX(0);
        con4.setScaleY(0);
        con4.setAlpha(0);
        con4.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        textView.setAlpha(0);
        textView.setScaleX(0);
        textView.setScaleY(0);
        textView.animate().scaleX(1).scaleY(1).alpha(1).setDuration(1500).start();
    }
}