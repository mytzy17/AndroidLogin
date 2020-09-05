package com.example.androidlogin.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidlogin.R;

public class LoginActivity extends AppCompatActivity {

    EditText userId, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //userIdText = userIdInput
                //passwordText = passwordInput
                final String userIdInput = userId.getText().toString();
                final String passwordInput = password.getText().toString();

                if (userIdInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.mUserDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //userEntity = u
                            UserEntity u = userDao.login(userIdInput, passwordInput);
                            if(u == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String name = u.userId;
                                startActivity(new Intent(HomeActivity.getIntent(getApplicationContext(), name)));
                            }
                        }
                    }).start();
                }
            }
        });
    }


}