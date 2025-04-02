package com.ignismark.castor.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

class Converters {
    // LocalDate
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE) }
    }

    // List<String>
    @TypeConverter
    fun fromListToJsonString(list: List<String>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun fromJsonStringToList(jsonString: String): List<String> {
        return Json.decodeFromString(jsonString)
    }

    // Duration
    @TypeConverter
    fun fromDuration(duration: Duration?): Long? {
        return duration?.toLong(DurationUnit.SECONDS)
    }

    @TypeConverter
    fun toDuration(seconds: Long?): Duration? {
        return seconds?.seconds
    }
}