package com.example.androidlogin;

import android.content.Context;

import androidx.room.Room;

import com.example.androidlogin.roomdatabase.HomeActivity;
import com.example.androidlogin.roomdatabase.MainActivity;
import com.example.androidlogin.roomdatabase.UserDao;
import com.example.androidlogin.roomdatabase.UserDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public MainActivity mMainActivity;
    public HomeActivity mHomeActivity;

    @Before
    public void runBefore(){
        mMainActivity = new MainActivity();
        mHomeActivity = new HomeActivity();
    }

    @Test
    public void intentMain(){

    }

}