package com.example.syanym.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.syanym.model.Dictionary;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM dictionary")
    List<Dictionary> getAll();
    
    @Insert
    void insert(Dictionary task);
    
    @Delete
    void delete(Dictionary task);
    
    @Update
    void update(Dictionary task);
}
