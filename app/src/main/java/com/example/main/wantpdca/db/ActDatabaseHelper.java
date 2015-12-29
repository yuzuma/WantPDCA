package com.example.main.wantpdca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.main.wantpdca.db.entity.ActEntity;
import com.example.main.wantpdca.db.entity.WantDeatilEntity;
import com.example.main.wantpdca.db.entity.WantEntity;

/**
 * Created by main on 2015/12/27.
 */
public class ActDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wantpdca";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "act";
    public static final String ACT_CREATE_TABLE = "" +
            "create table " + TABLE_NAME +  "(" +
            "actId integer primary key," +
            "wantId integer," +
            "actTitle text not null," +
            "actText  text," +
            "actImage  text," +
            "actDeadLine integer," +
            "createdAt integer," +
            "updatedAt integer" +
            ");";


    public ActDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //wantDatabaseHelperのonCreateで作成してもらう。
        //db.execSQL(ACT_CREATE_TABLE);
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
        values.put("actDeadLine", actEntity.getActDeadLine());
        values.put("createdAt",System.currentTimeMillis());
        values.put("updatedAt",System.currentTimeMillis());
        ret = db.insert(TABLE_NAME, null, values);

        return ret;

    }

    public ActEntity getActBywantId(int wantId){
        ActEntity entity;

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from act where wantId = ? order by updatedAt desc limit 1", new String[]{String.valueOf(wantId)});

        boolean hasNext = cursor.moveToFirst();
        entity = new ActEntity();
        entity.setActId(cursor.getInt(cursor.getColumnIndex("actId")));
        entity.setActTitle(cursor.getString(cursor.getColumnIndex("actTitle")));
        entity.setActDeadLine(cursor.getLong(cursor.getColumnIndex("actDeadLine")));
        entity.setActImage(cursor.getString(cursor.getColumnIndex("actImage")));
        return entity;
    }
}
