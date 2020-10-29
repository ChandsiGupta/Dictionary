package com.example.syanym.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.syanym.dao.TaskDao;
import com.example.syanym.model.Dictionary;

@Database(entities = {Dictionary.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
