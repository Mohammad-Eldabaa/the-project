package com.example.shifaaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class First_aid_activity extends AppCompatActivity {

    RecyclerView RView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        RView = findViewById(R.id.RView_first_aid);

        ArrayList<Danger> dangers = new ArrayList<>();
        dangers.add(new Danger(R.drawable.p1,"حالات الشرقان او الغصة"));
        dangers.add(new Danger(R.drawable.p2,"حالات النزيف"));
        dangers.add(new Danger(R.drawable.p3,"حالات الكسور"));
        dangers.add(new Danger(R.drawable.p4,"التنفس الصناعي"));
        dangers.add(new Danger(R.drawable.p5,"انعاش القلب والرئتين"));
        dangers.add(new Danger(R.drawable.p6,"حالة الصدمة"));
        dangers.add(new Danger(R.drawable.p7,"حالة الاختناق"));
        dangers.add(new Danger(R.drawable.p8,"حالة بلع اللسان"));
        dangers.add(new Danger(R.drawable.p9,"حالات الشنق او الخنق"));
        dangers.add(new Danger(R.drawable.p10,"حالة الغرق"));
        dangers.add(new Danger(R.drawable.p11,"حالة الاغماء"));
        dangers.add(new Danger(R.drawable.p12,"اغماء مرضي السكر"));
        dangers.add(new Danger(R.drawable.p13,"اغماء مرضي الكبد"));
        dangers.add(new Danger(R.drawable.p14,"السكتة الدماغية"));
        dangers.add(new Danger(R.drawable.p15,"تشخيص حالة الوفاة"));
        dangers.add(new Danger(R.drawable.p16,"حالات الحروق"));
        dangers.add(new Danger(R.drawable.p17,"ضربة الشمس"));
        dangers.add(new Danger(R.drawable.p18,"حالات الحمي او السخونية"));
        dangers.add(new Danger(R.drawable.p19,"الكدمات والجروح"));
        dangers.add(new Danger(R.drawable.p20,"حالات نزيف الانف"));
        dangers.add(new Danger(R.drawable.p21,"كسر سن او ضرس"));
        dangers.add(new Danger(R.drawable.p22,"خروج سائل من الاذن"));
        dangers.add(new Danger(R.drawable.p23,"دخول جسم غريب للعين"));
        dangers.add(new Danger(R.drawable.p24,"عضة الثعبان"));
        dangers.add(new Danger(R.drawable.p25,"لدغة العقرب"));
        dangers.add(new Danger(R.drawable.p26,"لسعة قنديل البحر"));
        dangers.add(new Danger(R.drawable.p27,"لسعة النحلة"));
        dangers.add(new Danger(R.drawable.p28,"عضة الحيوانات"));
        dangers.add(new Danger(R.drawable.p29,"نوبات الصرع او التشنجات"));
        dangers.add(new Danger(R.drawable.p30,"التواء المفاصل"));
        dangers.add(new Danger(R.drawable.p31,"ازمة الربو"));

        RViewAdapter adapter= new RViewAdapter(dangers, new OnItemClickListener() {
            @Override
            public void onItemClick(int dangerId) {
                Toast.makeText(First_aid_activity.this, String.valueOf(dangerId), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), frist_aid_show_activity.class);
                intent.putExtra("dangerId",dangerId);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        RView.setHasFixedSize(true);
        RView.setLayoutManager(LM);
        RView.setAdapter(adapter);







    }
}