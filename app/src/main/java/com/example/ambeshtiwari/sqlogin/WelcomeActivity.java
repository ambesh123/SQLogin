package com.example.ambeshtiwari.sqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView textView=findViewById(R.id.welcomeText);
        textView.setText( "Welcome "+getIntent().getStringExtra("username"));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Please Logout First", Toast.LENGTH_SHORT).show();
    }

    public void logOut(View view) {
        startActivity(new Intent (this,LoginActivity.class));
        finish();
    }
}
