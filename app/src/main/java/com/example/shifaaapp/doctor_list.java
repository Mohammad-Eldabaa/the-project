package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class doctor_list extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Doctors> doctors;
    ArrayList<Doctors> doctors_of_partion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        recyclerView = findViewById(R.id.RV_doctor);
//        doctors = new ArrayList<Doctors>();
//        doctors.add(new Doctors("mohammad Ramadan Eldabaa","Eyes partion","tanat see street"));
//        doctors.add(new Doctors("mohammad Ramadan Eldabaa","Eyes partion","tanat see street"));
//        doctors.add(new Doctors("mohammad Ramadan Eldabaa","Eyes partion","tanat see street"));
//        doctors.add(new Doctors("mohammad Ramadan Eldabaa","Eyes partion","tanat see street"));
//        doctors.add(new Doctors("mohammad Ramadan Eldabaa","Eyes partion","tanat see street"));



        Intent intent = getIntent();
        int id_partion = intent.getIntExtra("id_partion",0) ;

        Log.i("g1", "TTTTTTTTTTTTTTTTTTTTTttt");

        DatabaseAccess_doctors databaseAccess = DatabaseAccess_doctors.getInstance(getApplicationContext());
        databaseAccess.open();

        doctors = databaseAccess.get_names();
        doctors_of_partion =new ArrayList<Doctors>();

        Log.i("g3", String.valueOf(id_partion));
        for (Doctors doc: doctors)
        {
            if (doc.getId() == id_partion)
                doctors_of_partion.add(doc);

            Log.i("g2", "TTTTTTTTTTTTTTTTTTTTTttt");
        }


        RViewAdapter_doctors adapter = new RViewAdapter_doctors(doctors_of_partion, new OnItemClickListener() {
            @Override
            public void onItemClick(int dangerId) {

            }
        });

        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LM);
        recyclerView.setAdapter(adapter);

    }
}