package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class Call extends AppCompatActivity {
    RecyclerView RView ;
    SearchView searchView;
    ArrayList<Danger> dangers;
    SearchView txtStepeechInput;
    Button btnSpeak;

    private static final int REQ_CODE_SPEECH_INPUT = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        call_1();
        search();
        speek();

    }

    //--------------------------------------------------------------------------------------------------

    public void call_1()
    {

        RView = findViewById(R.id.RView_call);

        dangers = new ArrayList<>();
        dangers.add(new Danger(R.drawable.whitephoto,"القاهره",1));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسكندريه",2));
        dangers.add(new Danger(R.drawable.whitephoto,"الإسماعيليه",3));
        dangers.add(new Danger(R.drawable.whitephoto,"البحيره",4));
        dangers.add(new Danger(R.drawable.whitephoto,"الغربيه",5));
        dangers.add(new Danger(R.drawable.whitephoto,"الجيزه",6));
        dangers.add(new Danger(R.drawable.whitephoto,"اسوان",7));
        dangers.add(new Danger(R.drawable.whitephoto,"اسيوط",8));
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


    //---------------------------------------------------------------------------------------------------
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

    //-------------------------------------------------------------------------------------------------
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
                    Intent intent = new Intent(getBaseContext(), Call_numbers.class);
                    intent.putExtra("num",areas.get(dangerId-1).getId());
                    startActivity(intent);
                }
            });

            RView.setAdapter(adapter);

        }

    }


    //-------------------------------------------------------------------------------------------------


    public void speek()
    {
        txtStepeechInput = findViewById(R.id.searchView_area);
        btnSpeak = findViewById(R.id.Button_area);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
    }

    //-------------------------------------------------------------------------------------------------

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchView.setQuery(result.get(0), false);
                }
                break;
            }
        }
    }



}