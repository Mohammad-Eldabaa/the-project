package com.example.shifaaapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Call_numbers extends AppCompatActivity {

    RecyclerView RView_numbers ;
    ArrayList<Numbers> show;
//    ArrayList<Numbers> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_numbers);

        RView_numbers = findViewById(R.id.RV_Call_number);
//        numbers = new ArrayList<>();
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
//        numbers.add(new Numbers("محمد","+201093413220","كوم حماده","201093413220",4));
        Log.i("sssssssssssssss", "sss");

        run();


    }

    public void run()
    {


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        show = new ArrayList<Numbers>();
        ArrayList<Numbers> persons = new ArrayList<Numbers>();


        Intent intent = getIntent();
        int id = intent.getIntExtra("num",1);
        persons = databaseAccess.get_names();






        for (int i=0; i<persons.size();i++)
        {
            if(persons.get(i).getId() == id)
                show.add(persons.get(i));
        }
//        show.add(persons.get(0));
        RViewAdapter_number adapter= new RViewAdapter_number(show, new OnItemClickListener() {
            @Override
            public void onItemClick(int dangerId) {
                copyToClipboard(String.valueOf(show.get(dangerId-1).getNumber()));
                Toast.makeText(Call_numbers.this, " تم نسخ الرقم ", Toast.LENGTH_SHORT).show();



            }
        });
        RecyclerView.LayoutManager LM = new LinearLayoutManager(this);

        RView_numbers.setHasFixedSize(true);
        RView_numbers.setLayoutManager(LM);
        RView_numbers.setAdapter(adapter);
    }

    private void copyToClipboard(String text) {
        // Get the Clipboard Manager
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // Create a ClipData object with the text
        ClipData clip = ClipData.newPlainText("label", text);

        // Set the ClipData to the Clipboard
        clipboard.setPrimaryClip(clip);

        // Notify the user
    }
}