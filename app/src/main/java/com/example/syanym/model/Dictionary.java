package com.example.syanym.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dictionary")
public class Dictionary {
    
    @PrimaryKey
    private Integer id;
    
    @ColumnInfo(name = "syn")
    private String syn;
    @ColumnInfo(name = "ant")
    private String ant;
    @ColumnInfo(name = "key")
    private String key;
    
    public Dictionary(Integer id, String key, String syn, String ant) {
        this.id = id;
        this.key = key;
        this.syn = syn;
        this.ant = ant;
    }
    
    public String getSyn() {
        return syn;
    }
    
    public void setSyn(String syn) {
        this.syn = syn;
    }
    
    public String getAnt() {
        return ant;
    }
    
    public void setAnt(String ant) {
        this.ant = ant;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}