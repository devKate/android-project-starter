package com.katien.project.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.katien.project.db.AppTypeConverters
import org.threeten.bp.Duration
import org.threeten.bp.Instant

@Entity(tableName = "profiles")

@TypeConverters(AppTypeConverters::class)
data class Profile(
        @PrimaryKey var id: String,
        @ColumnInfo(name = "caller")
        var caller: String,

        @ColumnInfo(name = "callee")
        var callee: String,

        @ColumnInfo(name = "incoming")
        var incoming: Boolean,

        @ColumnInfo(name = "missed")
        var missed: Boolean,

        @ColumnInfo(name = "duration")
        var duration: Duration,

        @ColumnInfo(name = "time")
        var time: Instant,

        @ColumnInfo(name = "credits")
        var credits: Int)