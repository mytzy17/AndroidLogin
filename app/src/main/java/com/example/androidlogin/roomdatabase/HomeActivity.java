package com.example.androidlogin.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidlogin.R;

public class HomeActivity extends AppCompatActivity {

    //tName = nameUser
    TextView nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameUser = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        nameUser.setText(name);
    }

    public static Intent getIntent(Context c, String userId){
        Intent i = new Intent(c, HomeActivity.class);
        i.putExtra("name", userId);

        return i;
    }

}