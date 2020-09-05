//tried to do thiss
package com.example.androidlogin;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.androidlogin.roomdatabase.UserDao;
import com.example.androidlogin.roomdatabase.UserDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DbTest {
    private UserDao userDao;
    private UserDatabase db;

    //opens the app, run good
    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();
        userDao = db.mUserDao();
    }

    //stops the app, run stop
    @After
    public void closeDb() throws IOException {
        db.close();
    }


}
