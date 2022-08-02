package com.example.soccernews.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    // Se deixar public, não necessita do get e setter
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public String image;
    public String link;
    public boolean favorite;

}
