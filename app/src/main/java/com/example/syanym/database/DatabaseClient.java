package com.example.syanym.database;

import android.content.Context;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.syanym.dao.TaskDao;
import com.example.syanym.model.Dictionary;
import com.huma.room_for_asset.RoomAsset;
    
    @Database(entities = Dictionary.class, exportSchema = false, version = 2)
    abstract  public class DatabaseClient extends RoomDatabase {
        
        private static final String DB_NAME = "user_db";
        
        private static DatabaseClient databaseClient;
        
        public static synchronized DatabaseClient getInstance(Context context) {
            databaseClient = RoomAsset.databaseBuilder(context.getApplicationContext(), DatabaseClient.class, "my_dictionary.db")
                    .build();
            return databaseClient;
        }
        
        public abstract TaskDao dictionaryDao();
    }

