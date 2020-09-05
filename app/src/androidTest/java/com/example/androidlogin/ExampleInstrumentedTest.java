package com.example.androidlogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.androidlogin.roomdatabase.HomeActivity;
import com.example.androidlogin.roomdatabase.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.androidlogin", appContext.getPackageName());
    }

    @Test
    public void checkIntent() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        Intent i = HomeActivity.getIntent(appContext, "din_djrain");

        assertEquals("com.example.androidlogin.roomdatabase.HomeActivity",
                i.resolveActivity(appContext.getPackageManager()).getClassName());
    }

}