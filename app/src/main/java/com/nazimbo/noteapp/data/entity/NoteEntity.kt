package com.nazimbo.noteapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Représente une note dans la base de données.
 * Chaque note est identifiée par un identifiant unique, contient un titre, le contenu de la note, et la date de dernière mise à jour.
 */
@Entity(tableName = "NoteEntity")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var updatedAt: LocalDateTime?,
    var title: String = "",
    var note: String = ""
)