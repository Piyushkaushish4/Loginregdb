package com.example.loginregdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper

{   public static final String DATABASENAME="Dbase";
    public static final String TABLENAME="table1";
    public static final String COL0="ID";
    public static final String COL1="Name";
    public static final String COL2="Email";
    public static final String COL3="Username";
    public static final String COL4="Password";


    public Database(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " +TABLENAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Username TEXT,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }
    public Boolean insertdata(String name, String Email, String Username, String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,name);
        contentValues.put(COL2,Email);
        contentValues.put(COL3,Username);
        contentValues.put(COL4,Password);
        long result=db.insert(TABLENAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
    public String getUserData(String name, String password) {
        String s = "null";
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLENAME + " WHERE Name='" + name + "' and Password='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    s = "found";
                    return s;
                } while (cursor.moveToNext());
            }
            else {
                s = "null";
            }
        }
        return s;
    }
    public String getUserData1(String name, String email)
    {
        String z="null";
        SQLiteDatabase db=this.getReadableDatabase();
        String query ="SELECT * FROM "+TABLENAME+" WHERE Name ='"+name+"' and Email='"+email+"'";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    z = "found";
                    return z;
                }
                while (cursor.moveToNext());

            } else {
                z = "null";

            }
        }
        return z;
    }
}
