package com.example.shifaaapp;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database_doctor_OpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "doctors.db";
    private static final int DATABASE_VERSION = 1;

    public Database_doctor_OpenHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
}
