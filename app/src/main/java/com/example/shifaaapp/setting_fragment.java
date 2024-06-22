package com.example.shifaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class setting_fragment extends Fragment {



    Button button_share,button_call,button_about,web_button;
    NetworkChangeReceiver networkChangeReceiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_setting_fragment, container, false);
        networkChangeReceiver = new NetworkChangeReceiver(getContext());


        button_share = view.findViewById(R.id.share_button);
        button_about = view.findViewById(R.id.about_button);
        button_call = view.findViewById(R.id.contact_button);
        web_button = view.findViewById(R.id.web_button);

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "The link";
//                copyToClipboard(link);
                shareTextToApps(link);
//                Toast.makeText(getContext(),"تم نسخ رابط المشاركة",Toast.LENGTH_SHORT).show();
            }
        });

        web_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "The link";
//                copyToClipboard(link);
                shareTextToApps(link);
//                Toast.makeText(getContext(),"تم نسخ رابط المشاركة",Toast.LENGTH_SHORT).show();
            }
        });



        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!networkChangeReceiver.isNetworkAvailable(getContext()))
                {
                    Toast.makeText(getContext(), "لا يوجد انترنت", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getActivity(), about_activity.class);
                    startActivity(intent);
                }
            }
        });




        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!networkChangeReceiver.isNetworkAvailable(getContext()))
                {
                    Toast.makeText(getContext(), "لا يوجد انترنت", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        Intent intent = new Intent(getActivity(), MainActivity2.class);
                        intent.putExtra("url", "https://forms.gle/CR6DF9q27ZefKJQb9");
                        startActivity(intent);
                    }
            }
        });
        return view;
    }



    //_____________________________________________________________________________________________________________
    private void shareTextToApps(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);

        // Create a chooser to let the user select the app to share with
        Intent chooser = Intent.createChooser(intent, "شارك التطبيق مع ");

        try {
            startActivity(chooser);
        } catch (Exception e) {
            Toast.makeText(requireContext(), "No app available to share text", Toast.LENGTH_SHORT).show();
        }
    }


}