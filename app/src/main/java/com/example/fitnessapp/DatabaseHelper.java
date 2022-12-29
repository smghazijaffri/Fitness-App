package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Pedometer", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Steps(id integer primary key, duration String, steps integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop table if exists Steps");
      onCreate(sqLiteDatabase);
    }

    public void InsertSteps(String Duration, int Steps)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Duration",Duration);
        cv.put("Steps",Steps);
        /*cv.put("Time", String.valueOf(date));*/
        db.insert("Steps",null,cv);
    }

    public Cursor GetDataCursor()
    {
       SQLiteDatabase db = getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from Steps order by id desc",null);
       return cursor;
    }
}