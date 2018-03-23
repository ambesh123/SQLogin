package com.example.ambeshtiwari.sqlogin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManageActivity extends AppCompatActivity {

    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        dbh = new DatabaseHelper(this);
        updateUsers();
        final EditText u2Del= (EditText)findViewById(R.id.u2del);
        Button button= (Button)findViewById(R.id.delButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db= dbh.getWritableDatabase();
                db.execSQL("DELETE FROM "+DatabaseHelper.TABLENAME+" WHERE "+DatabaseHelper.USERNAME+" = \""+u2Del.getText().toString()+"\";");
                db.close();
                updateUsers();
                u2Del.setText("");
            }

        });
    }

    public void updateUsers()
    {
        TextView list= findViewById(R.id.list);
        list.setText((CharSequence) dbh.dbToString());
    }
}
