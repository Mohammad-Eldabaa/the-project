package com.example.shifaaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity  {


    int home = 1;


    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(2, true);
            //   bottomNavigation.setIconsSize(36, 36);



        viewPager = findViewById(R.id.fragmentContainerView);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1,false);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.listc));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.the_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_settings_24));
//
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                int itemId = model.getId();
                switch (itemId) {
                    case 1:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case 2:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case 3:
                        viewPager.setCurrentItem(2, true);
                    // Add more cases for additional items
                    default:
                        break;
                }
                return null;
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigation.show(position + 1, true);
            }
        });

// bottomNavigation.setCount(2,"8");
// bottomNavigation.show(home,true);

//        animate();

    }


    //------------------------------------------------------------------------------------------------




    //------------------------------------------------------------------------------------------------

}