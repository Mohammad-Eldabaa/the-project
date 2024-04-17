package com.example.shifaaapp;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database_medecal_OpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "medical.db";
    private static final int DATABASE_VERSION = 1;

    public Database_medecal_OpenHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
}
