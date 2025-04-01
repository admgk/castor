package com.ignismark.castor.data.database

import androidx.room.TypeConverter
import java.time.LocalDate
import kotlin.time.Duration

class Converters {
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun stringToDuration(value: String?): Duration? {
        return value?.let { Duration.parse(it) }
    }

    @TypeConverter
    fun durationToString(duration: Duration?): String? {
        return duration?.toString()
    }
}