
package com.example.ambeshtiwari.sqlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="users.db";   //To give own database
    public static final int DATABASE_VERSION=1;           //Your defined version
    public static final String TABLENAME="Users";
    public static final String USERNAME="USERNAME";                //to define name Column
    public static final String PASSWORD="PASSWORD";         //for Password column

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE "+TABLENAME+" ( "+USERNAME+" TEXT PRIMARY KEY, "+PASSWORD+" TEXT );";
        database.execSQL(query);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       // db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
       // onCreate(db);
    }

    public void addUser(String username,String password){
        ContentValues values = new ContentValues();
        values.put(USERNAME,username);
        values.put(PASSWORD,password);
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLENAME,null,values);
        db.close();
    }

    public String dbToString(){
        String dbString="";
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLENAME,null);
        cursor.moveToFirst();
        do{
            dbString+=cursor.getString(0)+"\t"+cursor.getString(1)+"\n";
        }while(cursor.moveToNext());
        db.close();
     return dbString;
    }
}
