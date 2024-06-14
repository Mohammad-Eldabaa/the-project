package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class docto_show_activity extends AppCompatActivity {

    TextView TV_name;
    TextView TV_title;
    TextView TV_part;
    TextView TV_price;
    TextView TV_about;
    String name;
    String title;
    String about;
    String part;
    int price;
    int star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docto_show);







                TV_name = findViewById(R.id.TV_doctor_name);
                TV_title = findViewById(R.id.TV_doctor_title);
                TV_about = findViewById(R.id.TV_doctor_about);
                TV_part = findViewById(R.id.TV_doctor_part);
                TV_price = findViewById(R.id.TV_doctor_price);

        Intent intent = getIntent();
                name = intent.getStringExtra("name");
                title = intent.getStringExtra("title");
                about = intent.getStringExtra("about");
                part = intent.getStringExtra("part");
                price = intent.getIntExtra("price",0) ;
                star = intent.getIntExtra("price",0) ;


        Log.i("999999999999999999", String.valueOf(name));



        TV_price.setText(String.valueOf(price));
        TV_name.setText(name);
        TV_title.setText(title);
        TV_about.setText(about);
        TV_part.setText(part);

    }








//---------------------------------------------------------------------------------------------------
//    public void run(String name,String title, String about, String part, int price)
//    {
//        TV_name = findViewById(R.id.TV_doctor_name);
//        TV_title = findViewById(R.id.TV_doctor_title);
//        TV_about = findViewById(R.id.TV_doctor_about);
//        TV_part = findViewById(R.id.TV_doctor_part);
//        TV_price = findViewById(R.id.TV_doctor_price);
//
//        TV_price.setText(String.valueOf(price));
//        TV_name.setText(name);
//        TV_title.setText(title);
//        TV_about.setText(about);
//        TV_part.setText(part);
//    }
}