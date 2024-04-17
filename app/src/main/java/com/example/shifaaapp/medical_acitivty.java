package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class medical_acitivty extends AppCompatActivity {

    ListView listView;
    Medical_C medical_c;
    ArrayList<Medical_C> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        Log.i("111", "ssssssssss");
        DatabaseAccess_medical database_m_Access = DatabaseAccess_medical.getInstance(getApplicationContext());
        database_m_Access.open();

        Log.i("222", "ssssssssss");
        ArrayList<Medical_C> meds = database_m_Access.get_names();


        listView = findViewById(R.id.medical_listView);
        ArrayList<String> a = new ArrayList<>();


        Log.i("333", "ssssssssss");
        for (int i=0; i<meds.size();i++)
        {
            String m = meds.get(i).getTname();
            a.add(m);
        }


        Log.i("111", String.valueOf(a));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,a );
        listView.setAdapter(adapter);
        Log.i("777", "ssssssssss");
        database_m_Access.close();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(medical_acitivty.this, "You clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), medical_show.class);
                intent.putExtra("Med_name",selectedItem);
                startActivity(intent);

            }
        });




    }
}

