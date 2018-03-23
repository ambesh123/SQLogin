package com.example.ambeshtiwari.sqlogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper= new DatabaseHelper(this);
        SQLiteDatabase db= databaseHelper.getWritableDatabase();
        //db.execSQL("INSERT INTO "+DatabaseHelper.TABLENAME+" VALUES (\"GANGER\", \"banger\");");
        //db.execSQL("DELETE FROM "+DatabaseHelper.TABLENAME+" WHERE "+DatabaseHelper.USERNAME+" = \"GANGER\";");
    }

    public void logIn(View view) {
        boolean flag=false;
        String username=((EditText)findViewById(R.id.username)).getText().toString();
        String password=((EditText)findViewById(R.id.password)).getText().toString();
        SQLiteDatabase db=databaseHelper.getWritableDatabase();
        String query="SELECT * FROM "+DatabaseHelper.TABLENAME;
        Cursor cursor= db.rawQuery(query,null);
        cursor.moveToFirst();
       do{
            if(username.equals(cursor.getString(cursor.getColumnIndex(DatabaseHelper.USERNAME))) && password.equals(cursor.getString(cursor.getColumnIndex(DatabaseHelper.PASSWORD))))flag=true;
        }while(cursor.moveToNext());

       db.close();
        if(flag){
            Toast.makeText(this, "Authenticated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);
            finish();
        }
        else Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show();

    }

    public void signUp(View v)
    {
        Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }


    public void manageUsers(View view) {
        startActivity(new Intent(LoginActivity.this,ManageActivity.class));
    }


}
