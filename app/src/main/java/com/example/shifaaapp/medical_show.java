package com.example.shifaaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class medical_show extends AppCompatActivity {


    TextView tv_Tame;
    TextView tv_Sname;
    TextView tv_use;
    TextView tv_Xuse;
    String med_name;

    Boolean isbought = false;
    Button button;
    public static ArrayList<String> str = null ;


    Medical_C med1 = null;


    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_show);

        tv_Tame = findViewById(R.id.textView_Tname);
        tv_Sname = findViewById(R.id.textView_Sname);
        tv_use = findViewById(R.id.textView_use2);
        tv_Xuse = findViewById(R.id.textView_xuse2);
        button = findViewById(R.id.bought_btn);


        if (str== null)
            str = new ArrayList<>();


        Intent intent = getIntent();
        med_name = intent.getStringExtra("Med_name");

        DatabaseAccess_medical database_m_Access = DatabaseAccess_medical.getInstance(getApplicationContext());
        database_m_Access.open();

        ArrayList<Medical_C> meds = database_m_Access.get_names();



        for (Medical_C m: meds)
            if (m.getTname().equals(med_name))
                med1 = m;



            if (str != null){

                for (String m: str) {
                    if (m.equals(med1.getTname()))
                        isbought = true;
                }
            }


        if (isbought) {
            button.setBackgroundResource(R.drawable.delete_button);
            button.setText("حذف من قائمة المشتريات");
        }

        if (med1 != null) {
            Log.i("not null", String.valueOf(med_name));

            tv_Tame.setText(med1.getTname());
            tv_Sname.setText(med1.getSname());
            tv_use.setText(med1.getUse().replaceAll("\\n", ""));
            tv_Xuse.setText(med1.getXuse().replaceAll("\\n", ""));
        }

        else
            Log.i("null", String.valueOf(med_name));



        Log.i("boughtttt", String.valueOf(str.size()));





    }


    public void pay(View view)
    {
        button = findViewById(R.id.bought_btn);

        if(!isbought)
        {
            str.add(med1.getTname());
            button.setBackgroundResource(R.drawable.delete_button);
            button.setText("حذف من قائمة المشتريات");
            Toast.makeText(this,"تمت الاضافة",Toast.LENGTH_SHORT).show();
            isbought = true;
            parcher_fragment.parch();

        }else
        {
            button.setBackgroundResource(R.drawable.button_back);
            button.setText("اضافة الى قائمة المشتريات");
            Toast.makeText(this,"تم الحذف",Toast.LENGTH_SHORT).show();
            isbought = false;

            Iterator<String> iterator = str.iterator();
            while (iterator.hasNext()) {
                String m = iterator.next();
                if (m.equals(med1.getTname())) {
                    iterator.remove();
                    break;
                }
            }
        }



        parcher_fragment.parch();
    }
}