package com.example.shifaaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseAccess_medical {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess_medical instance;
    ArrayList<Medical_C> med;
    Cursor c = null;

    private DatabaseAccess_medical(Context context)
    {
        this.openHelper = new Database_medecal_OpenHelper(context);
    }

    public static DatabaseAccess_medical getInstance(Context context)
    {
        if (instance == null)
            instance = new DatabaseAccess_medical(context);

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


    public ArrayList<Medical_C> get_names()
    {

        Log.i("444", "ssssssssss");
        med = new ArrayList<>();

        Log.i("555", "ssssssssss");
        c = db.rawQuery("SELECT * FROM medical",null);

        Log.i("666", "s3");

        if (c != null && c.moveToFirst())
        {
            do {
                int c_id = c.getColumnIndex("id");
                int c_Sname = c.getColumnIndex("Sname");
                int c_Tname = c.getColumnIndex("Tbane");
                int c_use = c.getColumnIndex("use");
                int c_Xuse = c.getColumnIndex("Xuse");


                if (c_id != -1) {
                    Log.i("sssssssssssssss", "s5");
                    int id = c.getInt(c_id);
                    String Sname = c.getString(c_Sname);
                    String Tname = c.getString(c_Tname);
                    String use = c.getString(c_use);
                    String Xuse = c.getString(c_Xuse);


                    Medical_C num = new Medical_C(id, Sname, Tname,use,Xuse);
                    med.add(num);
                }
            }
            while (c.moveToNext());
            c.close();
        }
        return med;

    }





}
