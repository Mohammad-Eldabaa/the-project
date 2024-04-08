package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Call extends AppCompatActivity {
    RecyclerView RView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        RView = findViewById(R.id.RView_call);

        ArrayList<Danger> dangers = new ArrayList<>();
        dangers.add(new Danger(R.drawable.whitephoto,"القاهرة"));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسكندرية"));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسماعيلية"));
        dangers.add(new Danger(R.drawable.whitephoto,"البحيرة"));
        dangers.add(new Danger(R.drawable.whitephoto,"الغربية"));
        dangers.add(new Danger(R.drawable.whitephoto,"الجيزة"));
        dangers.add(new Danger(R.drawable.whitephoto,"أسوان"));
        dangers.add(new Danger(R.drawable.whitephoto,"أسيوط"));
        dangers.add(new Danger(R.drawable.whitephoto,"الأقصر"));
        dangers.add(new Danger(R.drawable.whitephoto,"البحر الأحمر"));
        dangers.add(new Danger(R.drawable.whitephoto,"شمال سيناء"));
        dangers.add(new Danger(R.drawable.whitephoto,"جنوب سيناء"));
        dangers.add(new Danger(R.drawable.whitephoto,"الدقهلية"));
        dangers.add(new Danger(R.drawable.whitephoto,"سوهاج"));
        dangers.add(new Danger(R.drawable.whitephoto,"السويس"));
        dangers.add(new Danger(R.drawable.whitephoto,"الشرقية"));
        dangers.add(new Danger(R.drawable.whitephoto,"بني سوسف"));
        dangers.add(new Danger(R.drawable.whitephoto,"بورسعيد"));


        RViewAdapter_area adapter= new RViewAdapter_area(dangers, new OnItemClickListener() {
            @Override
            public void onItemClick(int dangerId) {
                Toast.makeText(Call.this, String.valueOf(dangerId), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getBaseContext(), Call_numbers.class);
                intent.putExtra("num",dangerId);
                startActivity(intent);
            }
        });


        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        RView.setHasFixedSize(true);
        RView.setLayoutManager(LM);
        RView.setAdapter(adapter);
    }
}