package com.e.homework2;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context, "Login.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE user  (firstname text, lastname text, username text PRIMARY KEY, password text, password2 text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");

    }
    public boolean insert(String firstname, String lastname, String username, String password, String password2){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("laststname",lastname);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("password2",password2);

        long ins = db.insert("user", null, contentValues);
        if (ins==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
