package com.example.shifaaapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Iterator;


public class parcher_fragment extends Fragment {




    static ListView listView;
    Button button;
    String names = "";
    static ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parcher_fragment, container, false);


        listView = view.findViewById(R.id.lisView_bought);
        if (medical_show.str!=null)
        {

            adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, medical_show.str);
            listView.setAdapter(adapter);
        }


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                medical_show.str.remove(i);
                parch();
                return false;
            }
        });



        button = view.findViewById(R.id.parch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (medical_show.str != null  &&  medical_show.str.size() != 0)
                {
                    names = "";
                    Iterator<String> iterator = medical_show.str.iterator();
                    while (iterator.hasNext()) {
                        String m = iterator.next();
                        names += m + "\n";
                    }
                    Intent intent = new Intent(getActivity(), MainActivity2.class);
                    intent.putExtra("url", "https://forms.gle/EmHvEcr48o397PAr9");
                    startActivity(intent);
                    copyToClipboard(names);
                }
                else
                    Toast.makeText(getContext(), "قم باضافة بعض الأدوية أولا", Toast.LENGTH_SHORT).show();

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
        Toast.makeText(getContext(), "تم نسخ أسماء الأدوية", Toast.LENGTH_SHORT).show();
    }

    //_____________________________________________________________________________________________________
    public static void parch ()
    {

        if (listView != null && listView.getContext() != null && medical_show.str != null) {
            adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1, medical_show.str);
            listView.setAdapter(adapter);
        }
    }


}