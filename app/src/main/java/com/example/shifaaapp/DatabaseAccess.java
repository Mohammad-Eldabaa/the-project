package com.example.shifaaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseAccess{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    ArrayList<Numbers> persons;
    Cursor c = null;

    private DatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context)
    {
        if (instance == null)
            instance = new DatabaseAccess(context);

        return  instance;
    }

    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }

    public void close()
    {
        if (db != null)
            this.db.close();
    }


    public ArrayList<Numbers> get_names()
    {
        Log.i("sssssssssssssss", "s2");
        persons = new ArrayList<>();
        c = db.rawQuery("SELECT * FROM Number",null);

        Log.i("sssssssssssssss", "s3");

        if (c != null && c.moveToFirst())
        {
            do {
                Log.i("sssssssssssssss", "s4");
                int c_id = c.getColumnIndex("Id");
                int c_area = c.getColumnIndex("area");
                int c_subArea = c.getColumnIndex("subArea");
                int c_name = c.getColumnIndex("name");
                int c_number = c.getColumnIndex("number");


                if (c_id != -1) {
                    Log.i("sssssssssssssss", "s5");
                    int id = c.getInt(c_id);
                    String area = c.getString(c_area);
                    String subArea = c.getString(c_subArea);
                    String name = c.getString(c_name);
                    String number = c.getString(c_number);
                    Log.i("sssssssssssssss", "s6");

                    Numbers num = new Numbers(name, area, subArea,number,id);
                    persons.add(num);
                }
            }
            while (c.moveToNext());
            c.close();
        }
        Log.i("sssssssssssssss", "s7");
        return persons;

    }





}
