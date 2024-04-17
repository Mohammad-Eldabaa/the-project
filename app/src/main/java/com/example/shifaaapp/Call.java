package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Call extends AppCompatActivity {
    RecyclerView RView ;
    SearchView searchView;
    ArrayList<Danger> dangers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        RView = findViewById(R.id.RView_call);

        dangers = new ArrayList<>();
        dangers.add(new Danger(R.drawable.whitephoto,"القاهرة",1));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسكندرية",2));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسماعيلية",3));
        dangers.add(new Danger(R.drawable.whitephoto,"البحيرة",4));
        dangers.add(new Danger(R.drawable.whitephoto,"الغربية",5));
        dangers.add(new Danger(R.drawable.whitephoto,"الجيزة",6));
        dangers.add(new Danger(R.drawable.whitephoto,"أسوان",7));
        dangers.add(new Danger(R.drawable.whitephoto,"أسيوط",8));
        dangers.add(new Danger(R.drawable.whitephoto,"الأقصر",9));
        dangers.add(new Danger(R.drawable.whitephoto,"البحر الأحمر",10));
        dangers.add(new Danger(R.drawable.whitephoto,"شمال سيناء",11));
        dangers.add(new Danger(R.drawable.whitephoto,"جنوب سيناء",12));
        dangers.add(new Danger(R.drawable.whitephoto,"الدقهلية",13));
        dangers.add(new Danger(R.drawable.whitephoto,"سوهاج",14));
        dangers.add(new Danger(R.drawable.whitephoto,"السويس",15));
        dangers.add(new Danger(R.drawable.whitephoto,"الشرقية",16));
        dangers.add(new Danger(R.drawable.whitephoto,"بني سوسف",17));
        dangers.add(new Danger(R.drawable.whitephoto,"بورسعيد",18));


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

        search();
    }

    //--------------------------------------------------------------------------------------------------


    public void search()
    {
        searchView = findViewById(R.id.searchView_area);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return false;
            }
        });
    }

    private void fileList(String newText) {
        ArrayList<Danger> areas = new ArrayList<>();
        for (Danger danger: dangers)
        {
            if (danger.getName().toLowerCase().contains(newText.toLowerCase()))
                areas.add(danger);
        }

        if (areas.isEmpty())
        {
            Toast.makeText(this,"غير موجود",Toast.LENGTH_SHORT).show();
            RView = findViewById(R.id.RView_call);
            RView.setAdapter(null);
        }
        else
        {
            RView = findViewById(R.id.RView_call);
            RViewAdapter adapter= new RViewAdapter(areas, new OnItemClickListener() {
                @Override
                public void onItemClick(int dangerId) {
                    Toast.makeText(Call.this, String.valueOf(areas.get(dangerId-1).getId()), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), Call_numbers.class);
                    intent.putExtra("num",areas.get(dangerId-1).getId());
                    startActivity(intent);
                }
            });

            RView.setAdapter(adapter);

        }

    }


}