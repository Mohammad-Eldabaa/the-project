package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class setting_fragment extends Fragment {



    Button button_share,button_call,button_about;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_setting_fragment, container, false);

        button_share = view.findViewById(R.id.share_button);
        button_about = view.findViewById(R.id.about_button);
        button_call = view.findViewById(R.id.contact_button);

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("url","https://youtube.com/");
                startActivity(intent);
            }
        });



        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });



        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("url","https://youtube.com/");
                startActivity(intent);
            }
        });
        return view;
    }


}