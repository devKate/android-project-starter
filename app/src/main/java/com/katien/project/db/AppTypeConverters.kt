package com.katien.project.db

import androidx.room.TypeConverter
import org.threeten.bp.Duration
import org.threeten.bp.Instant

object AppTypeConverters {

    @TypeConverter
    @JvmStatic
    fun durationToLong(duration: Duration) = duration.seconds

    @TypeConverter
    @JvmStatic
    fun longToDuration(seconds: Long) = Duration.ofSeconds(seconds)

    @TypeConverter
    @JvmStatic
    fun instantToLong(instant: Instant) = instant.epochSecond

    @TypeConverter
    @JvmStatic
    fun longToInstant(secondsSinceEpoch: Long) = Instant.ofEpochSecond(secondsSinceEpoch)
}