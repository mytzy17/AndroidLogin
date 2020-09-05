package com.example.androidlogin;

import android.content.Context;

import androidx.room.Room;

import com.example.androidlogin.roomdatabase.MainActivity;
import com.example.androidlogin.roomdatabase.UserDao;
import com.example.androidlogin.roomdatabase.UserDatabase;
import com.example.androidlogin.roomdatabase.UserEntity;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {
    @Test
    public void checkUserAndPassword(){
        String userId = "din_djarin";
        String password = "baby_yoda_ftw";
        String name = "David";

        UserEntity e = new UserEntity();

        e.setName(name);
        e.setUserId(userId);
        e.setPassword(password);

        //CHECKS THE ENTITY IS VALID
        assertEquals(true, MainActivity.validateInput(e));
    }




}
