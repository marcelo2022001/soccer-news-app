package com.example.soccernews.data.remote;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.soccernews.Domain.News;
import com.example.soccernews.data.local.NewsDao;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
