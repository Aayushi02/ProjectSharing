package com.example.lenovo.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Dtabase_helper extends SQLiteOpenHelper {
    public static final String Name = "Flipmooc.db";
    public static final String Table_Name = "Info";
    public static final String col1 = "user_name";
    public static final String col2 = "password";
    public static final String col3 = "phone";
    public static final String col4 = "email";
    public static final String col5 = "type";
    public Dtabase_helper(Context context) {
        super(context, Table_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + Table_Name + " (user_name TEXT PRIMARY KEY,password INTEGER,phone INTEGER,email INTEGER,type TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + Table_Name);
        onCreate(db);
    }

    public boolean insert_data(String username, String password, String phone, String email, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, username);
        cv.put(col2, password);
        cv.put(col3, phone);
        cv.put(col4, email);
        cv.put(col5, type);
        long result = db.insert(Table_Name, null, cv);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public  static String str = new String();

    public String searchpass(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select user_name, password, type from " + Table_Name;
        Cursor r = db.rawQuery(query, null);
        String a, b,c;
        c="Company";
        b = "not found";
        if (r.moveToFirst()) {
            do {
                a = r.getString(0);
                if (a.equals(username)) {
                    b = r.getString(1);
                    c= r.getString(2);
                    break;
                }

            } while (r.moveToNext());
        }
        str = c;
        db.close();
        return b;
    }

    public String searchutype(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select user_name, type from " + Table_Name;
        Cursor r = db.rawQuery(query, null);
        String a,c;
        c= "Company";
        if(r.moveToFirst()){
            do {
                a=r.getString(0);
                if(a.equals(username)){
                    c= r.getString(1);
                    break;
                }
            }while(r.moveToNext());
        }
        db.close();
        return str;
    }
}


