package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.io.InputStream;

public class frist_aid_show_activity extends AppCompatActivity {
    int id;
    String url;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_aid_show);

        Intent intent = getIntent();
        id = intent.getIntExtra("dangerId",1) +1;



        TextView textView = findViewById(R.id.textView_FAid);
        String ss  = "ssss";

        InputStream input = null;
        try {

            String check = O_file();
            if (check != "error")
                 input = getAssets().open(check);


            int size = input.available();
            byte[] addtext = new byte[size];
            input.read(addtext);
            input.close();
            ss = new String(addtext);



        } catch (Exception e) {
            e.printStackTrace();
        }
        textView.setText(Html.fromHtml(ss));

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(url, 0);
                youTubePlayer.pause();

            }
        });


    }

    public String O_file()
    {
        switch (id){
            case 1:
                url="81BXd2Gi6kg";
                return "t1.text";
            case 2:
                url="kRYg6r1-Dww";
                return "t2.text";
            case 3:
                url="lY7DLGaz4ek";
                return "t3.txt";
            case 4:
                url="lCE9fXvyGLY";
                return "t4.txt";
            case 5:
                url="dP9qM2mCKzE";
                return "t5.txt";
            case 6:
                url="5XrgiIOOQD8";
                return "t6.txt";
            case 7:
                url="4rGsEejB--I";
                return "t7.txt";
            case 8:
                url="sYcMYoMPdzA";
                return "t8.txt";
            case 9:
                url="";
                return "t9.txt";
            case 10:
                url="yOFuyj4oqfs";
                return "t10.txt";
            case 11:
                url="docLv-Sj_eM";
                return "t11.txt";
            case 12:
                url="ESPX456nNyw";
                return "t12.txt";
            case 13:
                url="ik5iA2wuXww";
                return "t13.txt";
            case 14:
                url="g6rvWsHrUvs";
                return "t14.txt";
            case 15:
                url="jgxTAfzyZFI";
                return "t15.txt";
            case 16:
                url="HaC2oiBB7sI";
                return "t16.txt";
            case 17:
                url="uY8HNy9WBWk";
                return "t17.txt";
            case 18:
                url="RffwQ899VAA";
                return "t18.txt";
            case 19:
                url="4R51TZN2OoQ";
                return "t19.txt";
            case 20:
                url="8ww1woXfd90";
                return "t20.txt";
            case 21:
                url="4MuTpW2mpjo";
                return "t21.txt";
            case 22:
                url="jFIOvVERb0c";
                return "t22.txt";
            case 23:
                url="HivsOu2Jvo8";
                return "t23.txt";
            case 24:
                url="tPv5q7n_04M";
                return "t24.txt";
            case 25:
                url="EPX1eXbHNdc";
                return "t25.txt";
            case 26:
                url="yri8qDdLBlU";
                return "t26.txt";
            case 27:
                url="6Pi8TmXxInM";
                return "t27.txt";
            case 28:
                url="A2YaZndGiVU";
                return "t28.txt";
            case 29:
                url="LZ1N8MHoDi0";
                return "t29.txt";
            case 30:
                url="";
                return "t30.txt";
            case 31:
                url="fbL3OxfV4B8";
                return "t31.txt";
            default:
                url="3wnkPbC4zKg";
                return "error";
        }


    }

//    public String Video()
//    {
//
//
//          }

    }
