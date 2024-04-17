package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class medical_show extends AppCompatActivity {


    TextView tv_Tame;
    TextView tv_Sname;
    TextView tv_use;
    TextView tv_Xuse;
    String med_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_show);

        tv_Tame = findViewById(R.id.textView_Tname);
        tv_Sname = findViewById(R.id.textView_Sname);
        tv_use = findViewById(R.id.textView_use2);
        tv_Xuse = findViewById(R.id.textView_xuse2);
        Medical_C med1 = null;

        
        
        Intent intent = getIntent();
        med_name = intent.getStringExtra("Med_name");

        DatabaseAccess_medical database_m_Access = DatabaseAccess_medical.getInstance(getApplicationContext());
        database_m_Access.open();

        ArrayList<Medical_C> meds = database_m_Access.get_names();



        for (Medical_C m: meds)
            if (m.getTname().equals(med_name))
                med1 = m;




        if (med1 != null) {
            Log.i("not null", String.valueOf(med_name));

            tv_Tame.setText(med1.getTname());
            tv_Sname.setText(med1.getSname());
            tv_use.setText(med1.getUse());
            tv_Xuse.setText(med1.getXuse());
        }

        else
            Log.i("null", String.valueOf(med_name));



//        tv_Tame.setText(med1.getTname());


        
        


    }
}