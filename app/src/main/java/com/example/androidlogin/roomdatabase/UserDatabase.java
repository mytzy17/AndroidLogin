package com.example.androidlogin.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)

public abstract class UserDatabase extends RoomDatabase {

    private static final String dbName = "user";

    //userDatabase = sUserDatabase
    private static UserDatabase sUserDatabase;

    //c = context
    public static synchronized UserDatabase getUserDatabase(Context c){
        if(sUserDatabase == null){
            sUserDatabase = Room.databaseBuilder(c, UserDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sUserDatabase;
    }

    //userDao = mUserDao
    public abstract UserDao mUserDao();
}
