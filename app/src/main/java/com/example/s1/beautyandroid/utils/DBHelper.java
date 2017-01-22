package com.example.s1.beautyandroid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "beautynotification.db";
    private static final int DATABASE_VERSION = 2;

    public static final String NOTIFICATION_TABLE_NAME = "notification";
    public static final String NOTIFICATION_COLUMN_ID = "_id";
    public static final String NOTIFICATION_COLUMN_TITLE = "title";
    public static final String NOTIFICATION_COLUMN_DESCRIPTION = "description";
    public static final String NOTIFICATION_COLUMN_THUMBNAIL = "thumbnail";
    public static final String NOTIFICATION_COLUMN_NOTIFICATIONTYPE = "notificationtype";
    public static final String NOTIFICATION_COLUMN_NOTIFICATIONDATE = "notificationdate";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + NOTIFICATION_TABLE_NAME +
                        "(" + NOTIFICATION_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        NOTIFICATION_COLUMN_TITLE + " TEXT, " +
                        NOTIFICATION_COLUMN_DESCRIPTION + " TEXT, " +
                        NOTIFICATION_COLUMN_THUMBNAIL + " TEXT, " +
                        NOTIFICATION_COLUMN_NOTIFICATIONTYPE + " TEXT, " +
                        NOTIFICATION_COLUMN_NOTIFICATIONDATE + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOTIFICATION_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertNotification(String title, String description, String thumbnail, String notificationtype, String notificationdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NOTIFICATION_COLUMN_TITLE, title);
        contentValues.put(NOTIFICATION_COLUMN_DESCRIPTION, description);
        contentValues.put(NOTIFICATION_COLUMN_THUMBNAIL, thumbnail);
        contentValues.put(NOTIFICATION_COLUMN_NOTIFICATIONTYPE, notificationtype);
        contentValues.put(NOTIFICATION_COLUMN_NOTIFICATIONDATE, notificationdate);

        db.insert(NOTIFICATION_TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, NOTIFICATION_TABLE_NAME);
        return numRows;
    }

    public boolean updateNotification(Integer id, String title, String description, String thumbnail, String notificationtype, String notificationdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTIFICATION_COLUMN_TITLE, title);
        contentValues.put(NOTIFICATION_COLUMN_DESCRIPTION, description);
        contentValues.put(NOTIFICATION_COLUMN_THUMBNAIL, thumbnail);
        contentValues.put(NOTIFICATION_COLUMN_NOTIFICATIONTYPE, notificationtype);
        contentValues.put(NOTIFICATION_COLUMN_NOTIFICATIONDATE, notificationdate);
        db.update(NOTIFICATION_TABLE_NAME, contentValues, NOTIFICATION_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteNotification(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(NOTIFICATION_TABLE_NAME,
                NOTIFICATION_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public Cursor getNotification(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + NOTIFICATION_TABLE_NAME + " WHERE " +
                NOTIFICATION_COLUMN_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }

    public Cursor getAllNotifications() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + NOTIFICATION_TABLE_NAME, null );
        return res;
    }
}