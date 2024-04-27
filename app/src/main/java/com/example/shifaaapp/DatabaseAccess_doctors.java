package com.example.shifaaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess_doctors {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess_doctors instance;
    ArrayList<Doctors> persons;
    Cursor c = null;

    private DatabaseAccess_doctors(Context context)
    {
        this.openHelper = new Database_doctor_OpenHelper(context);
    }

    public static DatabaseAccess_doctors getInstance(Context context)
    {
        if (instance == null)
            instance = new DatabaseAccess_doctors(context);

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


    public ArrayList<Doctors> get_names()
    {
        persons = new ArrayList<>();
        c = db.rawQuery("SELECT * FROM doctors",null);



        if (c != null && c.moveToFirst())
        {
            do {
                int c_id = c.getColumnIndex("id");
                int c_name = c.getColumnIndex("name");
                int c_title = c.getColumnIndex("title");
                int c_part = c.getColumnIndex("part");
                int c_price = c.getColumnIndex("price");
                int c_star = c.getColumnIndex("star");
                int c_about = c.getColumnIndex("about");


                if (c_id != -1) {

                    int id = c.getInt(c_id);
                    String name = c.getString(c_name);
                    String title = c.getString(c_title);
                    String part = c.getString(c_part);
                    int price = c.getInt(c_price);
                    int star = c.getInt(c_part);
                    String about = c.getString(c_about);

                    Doctors doc = new Doctors(name, part, title,id,price,star,about);
                    persons.add(doc);
                }
            }
            while (c.moveToNext());
            c.close();
        }


        return persons;

    }





}
