package com.example.shifaaapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
                String link = "https://drive.google.com/file/d/1UJynv38jUn5yqety0OC0dQvr3X8vwUa1/view?usp=drive_link";
//                copyToClipboard(link);
                shareTextToApps(link);
//                Toast.makeText(getContext(),"تم نسخ رابط المشاركة",Toast.LENGTH_SHORT).show();
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
                intent.putExtra("url","https://forms.gle/CR6DF9q27ZefKJQb9");
                startActivity(intent);
            }
        });
        return view;
    }

    private void copyToClipboard(String text) {
        // Get the Clipboard Manager
        ClipboardManager clipboard = (ClipboardManager)requireContext().getSystemService(Context.CLIPBOARD_SERVICE);

        // Create a ClipData object with the text
        ClipData clip = ClipData.newPlainText("label", text);

        // Set the ClipData to the Clipboard
        clipboard.setPrimaryClip(clip);

        // Notify the user
    }

    //_____________________________________________________________________________________________________________
    private void shareTextToApps(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);

        // Create a chooser to let the user select the app to share with
        Intent chooser = Intent.createChooser(intent, "Share text via");

        try {
            startActivity(chooser);
        } catch (Exception e) {
            Toast.makeText(requireContext(), "No app available to share text", Toast.LENGTH_SHORT).show();
        }
    }


}