package com.example.ambeshtiwari.sqlogin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signUpAcc(View view) {
        String nun = ((EditText)findViewById(R.id.newusername)).getText().toString();
        String npw = ((EditText)findViewById(R.id.newpassword)).getText().toString();
        DatabaseHelper databaseHelper= new DatabaseHelper(this);
        databaseHelper.addUser(nun,npw);
        Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
    }
}
