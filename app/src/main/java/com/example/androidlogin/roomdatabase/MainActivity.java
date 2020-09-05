package com.example.androidlogin.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidlogin.R;

public class MainActivity extends AppCompatActivity {

    //Variables
    EditText userId, password, name;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Creating User Entity
                // u = userEntity

                final UserEntity u = new UserEntity();
                u.setUserId(userId.getText().toString());
                u.setPassword(password.getText().toString());
                u.setName(name.getText().toString());

                if(validateInput(u)){
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.mUserDao();

                    new Thread(new Runnable(){
                        @Override
                        public void run() {
                            //User Register
                            userDao.registerUser(u);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User registered!!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    //checks the username and password, this was private
    public static Boolean validateInput(UserEntity u){
        if(u.getName().isEmpty() || u.getPassword().isEmpty() || u.getName().isEmpty()){
            return false;
        }
        return true;
    }



}