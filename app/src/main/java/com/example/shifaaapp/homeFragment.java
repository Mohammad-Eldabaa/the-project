package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class homeFragment extends Fragment {

    private ConstraintLayout con1, con2, con3, con4;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize views
        con1 = view.findViewById(R.id.con1);
        con2 = view.findViewById(R.id.con2);
        con3 = view.findViewById(R.id.con3);
        con4 = view.findViewById(R.id.con4);
        imageView = view.findViewById(R.id.image_home);

        // Set click listeners
        con1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onclic_aid(v);
            }
        });
        con2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onclic_doc(v);
            }
        });
        con3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onclic_call(v);
            }
        });
        con4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onclic_med(v);
            }
        });

        // Start the animation
        animate();

        return view;
    }

    public void Onclic_aid(View view) {
        Intent intent = new Intent(getActivity(), First_aid_activity.class);
        startActivity(intent);
    }

    public void Onclic_call(View view) {
        Intent intent = new Intent(getActivity(), Call.class);
        startActivity(intent);
    }

    public void Onclic_med(View view) {
        Intent intent = new Intent(getActivity(), medical_acitivty.class);
        startActivity(intent);
    }

    public void Onclic_doc(View view) {
        Intent intent = new Intent(getActivity(), doctors_partions.class);
        startActivity(intent);
    }

    public void animate() {
        con2.setScaleX(0);
        con2.setScaleY(0);
        con2.setAlpha(0);
        con2.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con3.setScaleX(0);
        con3.setScaleY(0);
        con3.setAlpha(0);
        con3.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con1.setScaleX(0);
        con1.setScaleY(0);
        con1.setAlpha(0);
        con1.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        con4.setScaleX(0);
        con4.setScaleY(0);
        con4.setAlpha(0);
        con4.animate().scaleX(1).scaleY(1).rotation(360).alpha(1).setDuration(1000).start();

        imageView.setAlpha(0);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.animate().scaleX(1).scaleY(1).alpha(1).setDuration(1500).start();
    }
}
