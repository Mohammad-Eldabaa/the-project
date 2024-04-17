package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class First_aid_activity extends AppCompatActivity {

    RecyclerView RView ;
    SearchView searchView;
    ArrayList<Danger> dangers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
        create();
        search();
    }





    //----------------------------------------------------------------------------------------------------------------------
    public void create()
    {
        RView = findViewById(R.id.RView_first_aid);

        dangers = new ArrayList<>();
        dangers.add(new Danger(R.drawable.p1,"حالات الشرقان او الغصة",0));
        dangers.add(new Danger(R.drawable.p2,"حالات النزيف",1));
        dangers.add(new Danger(R.drawable.p3,"حالات الكسور",2));
        dangers.add(new Danger(R.drawable.p4,"التنفس الصناعي",3));
        dangers.add(new Danger(R.drawable.p5,"انعاش القلب والرئتين",4));
        dangers.add(new Danger(R.drawable.p6,"حالة الصدمة",5));
        dangers.add(new Danger(R.drawable.p7,"حالة الاختناق",6));
        dangers.add(new Danger(R.drawable.p8,"حالة بلع اللسان",7));
        dangers.add(new Danger(R.drawable.p9,"حالات الشنق او الخنق",8));
        dangers.add(new Danger(R.drawable.p10,"حالة الغرق",9));
        dangers.add(new Danger(R.drawable.p11,"حالة الاغماء",10));
        dangers.add(new Danger(R.drawable.p12,"اغماء مرضي السكر",11));
        dangers.add(new Danger(R.drawable.p13,"اغماء مرضي الكبد",12));
        dangers.add(new Danger(R.drawable.p14,"السكتة الدماغية",13));
        dangers.add(new Danger(R.drawable.p15,"تشخيص حالة الوفاة",14));
        dangers.add(new Danger(R.drawable.p16,"حالات الحروق",15));
        dangers.add(new Danger(R.drawable.p17,"ضربة الشمس",16));
        dangers.add(new Danger(R.drawable.p18,"حالات الحمي او السخونية",17));
        dangers.add(new Danger(R.drawable.p19,"الكدمات والجروح",18));
        dangers.add(new Danger(R.drawable.p20,"حالات نزيف الانف",19));
        dangers.add(new Danger(R.drawable.p21,"كسر سن او ضرس",20));
        dangers.add(new Danger(R.drawable.p22,"خروج سائل من الاذن",21));
        dangers.add(new Danger(R.drawable.p23,"دخول جسم غريب للعين",22));
        dangers.add(new Danger(R.drawable.p24,"عضة الثعبان",23));
        dangers.add(new Danger(R.drawable.p25,"لدغة العقرب",24));
        dangers.add(new Danger(R.drawable.p26,"لسعة قنديل البحر",25));
        dangers.add(new Danger(R.drawable.p27,"لسعة النحلة",26));
        dangers.add(new Danger(R.drawable.p28,"عضة الحيوانات",27));
        dangers.add(new Danger(R.drawable.p29,"نوبات الصرع او التشنجات",28));
        dangers.add(new Danger(R.drawable.p30,"التواء المفاصل",29));
        dangers.add(new Danger(R.drawable.p31,"ازمة الربو",30));

        RViewAdapter adapter= new RViewAdapter(dangers, new OnItemClickListener() {
            @Override
            public void onItemClick(int dangerId) {
                Toast.makeText(First_aid_activity.this, String.valueOf(dangers.get(dangerId-1).getId()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), frist_aid_show_activity.class);
                intent.putExtra("dangerId",dangers.get(dangerId-1).getId());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        RView.setHasFixedSize(true);
        RView.setLayoutManager(LM);
        RView.setAdapter(adapter);




    }


    //----------------------------------------------------------------------------------------------------------------------

    public void search()
    {
        searchView = findViewById(R.id.searchView);
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
        ArrayList<Danger> dan = new ArrayList<>();
        for (Danger danger: dangers)
        {
            if (danger.getName().toLowerCase().contains(newText.toLowerCase()))
                dan.add(danger);
        }

        if (dan.isEmpty())
        {
            Toast.makeText(this,"غير موجود",Toast.LENGTH_SHORT).show();
            RView = findViewById(R.id.RView_first_aid);
            RView.setAdapter(null);
        }
        else
        {
            RView = findViewById(R.id.RView_first_aid);
            RViewAdapter adapter= new RViewAdapter(dan, new OnItemClickListener() {
                @Override
                public void onItemClick(int dangerId) {
                    Toast.makeText(First_aid_activity.this, String.valueOf(dan.get(dangerId-1).getId()), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), frist_aid_show_activity.class);
                    intent.putExtra("dangerId",dan.get(dangerId-1).getId());
                    startActivity(intent);
                }
            });

            RView.setAdapter(adapter);

        }

    }

}