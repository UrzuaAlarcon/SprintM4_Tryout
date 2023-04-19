package com.example.sprintm4_tryout.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sprintm4_tryout.modelo.Elements;

@Database(
        entities = {Elements.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoElements daoElements();
}
