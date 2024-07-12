package com.nazimbo.noteapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Entity Note dans la base de données
 */

@Entity(tableName = "NoteEntity")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var updatedAt: LocalDateTime?,
    var title: String = "",
    var note: String = ""
)