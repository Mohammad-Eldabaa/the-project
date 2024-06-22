package com.example.shifaaapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class docto_show_activity extends AppCompatActivity {

    TextView TV_name;
    TextView TV_title;
    TextView TV_part;
    TextView TV_price;
    TextView TV_about;
    String name;
    String title;
    String about;
    String part;
    int price;
    int star;
    String data = "";
    NetworkChangeReceiver networkChangeReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docto_show);

        networkChangeReceiver = new NetworkChangeReceiver(this);





                TV_name = findViewById(R.id.TV_doctor_name);
                TV_title = findViewById(R.id.TV_doctor_title);
                TV_about = findViewById(R.id.TV_doctor_about);
                TV_part = findViewById(R.id.TV_doctor_part);
                TV_price = findViewById(R.id.TV_doctor_price);

        Intent intent = getIntent();
                name = intent.getStringExtra("name");
                title = intent.getStringExtra("title");
                about = intent.getStringExtra("about");
                part = intent.getStringExtra("part");
                price = intent.getIntExtra("price",0) ;
                star = intent.getIntExtra("price",0) ;


        data = name + " \n" + part;


        TV_price.setText(String.valueOf(price));
        TV_name.setText(name);
        TV_title.setText(title);
        TV_about.setText(about);
        TV_part.setText(part);

    }

    public void onClic(View view)
    {
        if (!networkChangeReceiver.isNetworkAvailable(this))
        {
            Toast.makeText(this, "لا يوجد انترنت", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(docto_show_activity.this, MainActivity2.class);
            copyToClipboard(data);
            intent.putExtra("url", "https://forms.gle/fbMCEnj5qYNcfvXG7");
            startActivity(intent);
            Toast.makeText(this, "تم نسخ بيانات الطبيب", Toast.LENGTH_SHORT).show();
        }
    }






//---------------------------------------------------------------------------------------------------
//    public void run(String name,String title, String about, String part, int price)
//    {
//        TV_name = findViewById(R.id.TV_doctor_name);
//        TV_title = findViewById(R.id.TV_doctor_title);
//        TV_about = findViewById(R.id.TV_doctor_about);
//        TV_part = findViewById(R.id.TV_doctor_part);
//        TV_price = findViewById(R.id.TV_doctor_price);
//
//        TV_price.setText(String.valueOf(price));
//        TV_name.setText(name);
//        TV_title.setText(title);
//        TV_about.setText(about);
//        TV_part.setText(part);
//    }

    private void copyToClipboard(String text) {
        // Get the Clipboard Manager
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

        // Create a ClipData object with the text
        ClipData clip = ClipData.newPlainText("label", text);

        // Set the ClipData to the Clipboard
        clipboard.setPrimaryClip(clip);

        // Notify the user
    }
}