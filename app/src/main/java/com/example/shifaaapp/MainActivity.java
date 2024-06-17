package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity  {


    int home = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(2, true);
            //   bottomNavigation.setIconsSize(36, 36);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.search_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.the_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_settings_24));

//
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                int itemId = model.getId();

                switch (itemId) {
                    case 1:
                        Toast.makeText(MainActivity.this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        // Handle default case or do nothing
                        break;
                }

                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                return null;
            }
        });


// bottomNavigation.setCount(2,"8");
// bottomNavigation.show(home,true);

//        animate();

    }


    //------------------------------------------------------------------------------------------------




    //------------------------------------------------------------------------------------------------

}