package com.example.main.wantpdca.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by main on 2015/12/27.
 */
public class PlanDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "wantpdca";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "plan";
    public static final String CREATE_TABLE = "" +
            "create table " + TABLE_NAME +  "(" +
            "planId integer primary key," +
            "wantId integer," +
            "planText text not null," +
            "planDeadLine integer," +
            "createdAt integer," +
            "updatedAt integer" +
            ");";


    public PlanDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
