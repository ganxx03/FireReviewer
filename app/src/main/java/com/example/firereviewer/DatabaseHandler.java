package com.example.firereviewer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper{


    public DatabaseHandler(Context context) {
        super(context, "ScoreDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = "create table ScoreTable(xValue INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, yValue INTEGER)";
        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insertdata(int valueY){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("yValue", valueY);

        db.insert("ScoreTable", null, contentValues);
    }
}
