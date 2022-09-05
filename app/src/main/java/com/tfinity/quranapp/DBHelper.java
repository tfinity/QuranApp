package com.tfinity.quranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "quran_databas.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void getdata(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM 'tayah' WHERE SuraID = 2", null);
        int count=0;
        if (cursorCourses.moveToFirst()) {
            do {
                count++;
                //Log.d("Columns", "getdata: "+cursorCourses.getColumnCount());
                Log.d("Arabic Text", "getdata: "+cursorCourses.getString(3));
                //Log.d("Surah", "getdata: "+cursorCourses.getInt(1));
                //Log.d("Surah", "count: "+count);
            } while (cursorCourses.moveToNext());

        }

    }
}
