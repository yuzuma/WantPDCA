package com.example.main.wantpdca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

import com.example.main.wantpdca.db.entity.WantDeatilEntity;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.dto.SearchWantListCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by main on 2015/12/23.
 */
public class WantDatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wantpdca";
    private static final String TABLE_NAME = "want";
    public static final String CREATE_TABLE = "" +
            "create table " + TABLE_NAME +  "(" +
            "wantId integer primary key," +
            "motivationId integer," +
            "wantText text not null," +
            "planId integer," +
            "doId integer," +
            "checkId integer," +
            "actId integer," +
            "createdAt integer," +
            "updatedAt integer" +
            ");";

    public WantDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(ActDatabaseHelper.ACT_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insert(WantEntity entity){
        long ret = 0;

        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("motivationId", entity.getMotivationId());
            values.put("wantText", entity.getWantText());
            values.put("createdAt",System.currentTimeMillis());


            ret = db.insert(TABLE_NAME, null, values);

            db.close();
            return ret;
        }catch(SQLiteException e){
            Log.e("error",e.toString());
            return -1;
        }

    }

    public List<WantEntity> getWantList(SearchWantListCondition earchWantListCondition){
        WantEntity entity;
        List<WantEntity> wantList = new ArrayList<WantEntity>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{"wantId", "motivationId", "wantText", "planId", "doId", "checkId", "actId", "createdAt", "updatedAt"},
                null,
                null,
                null,
                null,
                "wantId"
        );

        boolean hasNext = cursor.moveToFirst();
        while (hasNext){
            entity = new WantEntity ();
            entity.setWantId(cursor.getInt(cursor.getColumnIndex("wantId")));
            entity.setMotivationId(cursor.getInt(cursor.getColumnIndex("motivationId")));
            entity.setWantText(cursor.getString(cursor.getColumnIndex("wantText")));
            entity.setPlanId(cursor.getInt(cursor.getColumnIndex("planId")));
            entity.setDoId(cursor.getInt(cursor.getColumnIndex("doId")));
            entity.setCheckId(cursor.getInt(cursor.getColumnIndex("checkId")));
            entity.setActId(cursor.getInt(cursor.getColumnIndex("actId")));
            entity.setCreatedAt(cursor.getLong(cursor.getColumnIndex("createdAt")));
            entity.setUpdatedAt(cursor.getLong(cursor.getColumnIndex("updatedAt")));

            wantList.add(entity);
            hasNext = cursor.moveToNext();
        }
        return wantList;
    }


    public WantEntity getWantDetailById(int wantId){
        WantEntity entity;

        SQLiteDatabase db = getReadableDatabase();

       Cursor cursor = db.rawQuery("select * from want where wantId = ?", new String[]{String.valueOf(wantId)});

        boolean hasNext = cursor.moveToFirst();
            entity = new WantEntity();
            entity.setWantId(cursor.getInt(cursor.getColumnIndex("wantId")));
            //entity.setMotivationId(cursor.getInt(cursor.getColumnIndex("motivationId")));
            entity.setWantText(cursor.getString(cursor.getColumnIndex("wantText")));
//            entity.setPlanId(cursor.getInt(cursor.getColumnIndex("planId")));
//            entity.setDoId(cursor.getInt(cursor.getColumnIndex("doId")));
//            entity.setCheckId(cursor.getInt(cursor.getColumnIndex("checkId")));
//            entity.setActId(cursor.getInt(cursor.getColumnIndex("actId")));
//        entity.setActId(cursor.getInt(cursor.getColumnIndex("actId")));
//            entity.setCreatedAt(cursor.getInt(cursor.getColumnIndex("createdAt")));
//            entity.setUpdatedAt(cursor.getInt(cursor.getColumnIndex("updatedAt")));
        return entity;
    }

}
