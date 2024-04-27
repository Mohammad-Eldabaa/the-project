package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class doctors_partions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_partions);
    }

    public void onlick_gldia(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",1);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_asnan(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",2);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_hezam(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",3);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_aasab(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",5);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_btna(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",4);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_atfal(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",6);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_auon(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",8);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_sdr(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",9);
        startActivity(intent);
    }
//________________________________________________________________________________________________

    public void onlick_graha(View view)
    {
        Intent intent = new Intent(this, doctor_list.class);
        intent.putExtra("id_partion",7);
        startActivity(intent);
    }
//________________________________________________________________________________________________


}