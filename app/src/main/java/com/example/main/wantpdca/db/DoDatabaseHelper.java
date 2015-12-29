package com.example.main.wantpdca.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by main on 2015/12/27.
 */
public class DoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wantpdca";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "do";
    public static final String CREATE_TABLE = "" +
            "create table " + TABLE_NAME +  "(" +
            "doId integer primary key," +
            "wantId integer," +
            "doText text not null," +
            "doDeadLine integer," +
            "createdAt integer," +
            "updatedAt integer" +
            ");";


    public DoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
