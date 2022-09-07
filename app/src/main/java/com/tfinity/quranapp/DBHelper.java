package com.tfinity.quranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "quran_databas.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<DataModel> getdata(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM 'tayah'", null);
        ArrayList<DataModel> list = new ArrayList<DataModel>();
        int count=0;
        if (cursorCourses.moveToFirst()) {
            do {
                list.add(new DataModel(
                        cursorCourses.getInt(0),
                        cursorCourses.getInt(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getInt(8),
                        cursorCourses.getInt(9),
                        cursorCourses.getInt(10),
                        cursorCourses.getString(11)
                ));
            } while (cursorCourses.moveToNext());

        }
        return list;
    }
}
