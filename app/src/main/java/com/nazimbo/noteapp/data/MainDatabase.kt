package com.nazimbo.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nazimbo.noteapp.data.converter.LocalDateTypeConverter
import com.nazimbo.noteapp.data.dao.NoteDao
import com.nazimbo.noteapp.data.entity.NoteEntity

/**
 * Représente un modèle de données pour une note. Utilisé pour manipuler les données des notes dans l'application.
 *
 * @property id Identifiant unique de la note.
 * @property title Titre de la note.
 * @property note Contenu de la note.
 */
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
    /**
     * Fournit l'accès au DAO des notes pour interagir avec les données des notes dans la base de données.
     * @return L'instance de [NoteDao] pour accéder aux opérations CRUD sur les notes.
     */
    internal abstract fun noteDao(): NoteDao
}