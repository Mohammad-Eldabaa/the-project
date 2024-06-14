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

    Intent intent1;

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

        intent1 = new Intent(this, docto_show_activity.class);

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
            public void onItemClick(int Id) {



                intent1.putExtra("name",doctors_of_partion.get(Id-1).getName());
                intent1.putExtra("part",doctors_of_partion.get(Id-1).getPlace());
                intent1.putExtra("title",doctors_of_partion.get(Id-1).getPartion());
                intent1.putExtra("about",doctors_of_partion.get(Id-1).getAbout());

                intent1.putExtra("price",doctors_of_partion.get(Id-1).getPrice());
                intent1.putExtra("star",doctors_of_partion.get(Id-1).getStar());


                Log.i("88888888888888", doctors_of_partion.get(Id-1).getName());
                startActivity(intent1);


            }
        });

        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LM);
        recyclerView.setAdapter(adapter);

    }
}