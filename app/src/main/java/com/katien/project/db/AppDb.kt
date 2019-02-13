package com.katien.project.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katien.project.db.entity.Profile

@Database(entities = [Profile::class],
        version = 1)
abstract class AppDb : RoomDatabase() {
    companion object {
        val APP_DATABASE = "app_database"
    }

    abstract fun profileDao(): ProfileDao
}
