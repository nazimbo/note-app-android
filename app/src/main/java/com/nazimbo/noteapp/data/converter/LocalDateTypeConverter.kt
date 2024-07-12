package com.nazimbo.noteapp.data.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTypeConverter {

    @TypeConverter
    fun toLocalDateTime(dateString: String?): LocalDateTime? {
        return dateString?.let { LocalDateTime.parse(it) }
    }

    @TypeConverter
    fun localDateTimetoString(date: LocalDateTime?): String? {
        return date?.toString()
    }
}