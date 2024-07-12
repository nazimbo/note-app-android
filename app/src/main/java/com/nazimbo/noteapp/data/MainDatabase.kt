package com.nazimbo.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nazimbo.noteapp.data.converter.LocalDateTypeConverter
import com.nazimbo.noteapp.data.dao.NoteDao
import com.nazimbo.noteapp.data.entity.NoteEntity

@Database(
    version = 1,
    entities = [
        NoteEntity::class,
    ],
    exportSchema = true
)
@TypeConverters(
    LocalDateTypeConverter::class
)

internal abstract class MainDatabase : RoomDatabase() {
    internal abstract fun noteDao(): NoteDao
}