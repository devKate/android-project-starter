package com.katien.project.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.katien.project.db.entity.Profile


@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(profile: Profile)


    @Query("SELECT * FROM profiles")
    fun getAll(): LiveData<List<Profile>>


    @Query("SELECT * FROM profiles")
    fun getAllBlocking(): List<Profile>

    @Query("DELETE FROM profiles")
    fun deleteAllCallRecords()

}