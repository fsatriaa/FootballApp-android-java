package com.fdev22.footballapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PredictionModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract PredictionDao predictionDao();

    public static AppDatabase initDatabase(Context context){
        if (appDatabase==null){
            appDatabase= Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "prediction"
            ).allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
