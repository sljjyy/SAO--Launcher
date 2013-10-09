package com.sljjyy.sao.launcher.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 13-9-27.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "saolauncer.db";
    private static final String MAINMENU_TBL = "MainMenu";
    private static final String SUBMENU_TBL = "SubMenu";
    private SQLiteDatabase db;

    public DatabaseHelper(Context c) {
        super(c, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
        db.execSQL("CREATE TABLE MainMenu(id integer primary key autoincrement,index integer, name text, icopath text, ico2path text) ");
        db.execSQL("CREATE TABLE SubMenu(id integer primary key autoincrement, mainid integer, superid integer, index integer, name text, isdir integer,app text) ");
    }

    public void insert(String tabName,ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tabName, null, values);
        db.close();
    }

    public void delete(String tabName,int id) {
        if (db == null)
            db = getWritableDatabase();
        db.delete(tabName, "id=?", new String[]{String.valueOf(id)});
    }

    public Cursor query(String tabName) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query(tabName, null, null, null, null, null, null);
        return c;
    }

    public void close() {
        if (db != null)
            db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
