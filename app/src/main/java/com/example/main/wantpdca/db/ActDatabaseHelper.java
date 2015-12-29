package com.example.main.wantpdca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.main.wantpdca.db.entity.ActEntity;
import com.example.main.wantpdca.db.entity.WantEntity;

/**
 * Created by main on 2015/12/27.
 */
public class ActDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wantpdca";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "act";
    public static final String CREATE_TABLE = "" +
            "create table " + TABLE_NAME +  "(" +
            "actId integer primary key," +
            "wantId integer," +
            "actTitle text not null," +
            "actText  text not null," +
            "actImage  text not null," +
            "actDeadLine integer," +
            "createdAt integer," +
            "updatedAt integer" +
            ");";


    public ActDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(ActEntity actEntity){
        long ret = 0;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("wantId", actEntity.getWantId());
        values.put("actTitle", actEntity.getActTitle());
        values.put("actText", actEntity.getActText());
        values.put("actImage", actEntity.getActImage());
        values.put("createdAt",System.currentTimeMillis());
        values.put("updatedAt",System.currentTimeMillis());
        db.insert(TABLE_NAME, null, values);

        return ret;

    }
}
