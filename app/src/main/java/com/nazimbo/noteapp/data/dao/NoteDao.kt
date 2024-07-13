package com.nazimbo.noteapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nazimbo.noteapp.data.entity.NoteEntity

/**
 * Interface DAO pour l'accès aux données des notes dans la base de données.
 * Fournit les méthodes nécessaires pour interagir avec les notes stockées.
 */
@Dao
internal interface NoteDao {

    /**
     * Récupère toutes les notes stockées dans la base de données.
     * @return Un LiveData contenant la liste des [NoteEntity].
     */
    @Query("SELECT * FROM NoteEntity")
    fun getNotes(): LiveData<List<NoteEntity>>

    /**
     * Récupère une note spécifique par son identifiant.
     * @param id L'identifiant de la note à récupérer.
     * @return La [NoteEntity] correspondante, ou null si elle n'existe pas.
     */
    @Query("SELECT * FROM NoteEntity WHERE id=:id")
    suspend fun getNote(id: Long): NoteEntity?

    /**
     * Insère une nouvelle note dans la base de données ou met à jour une note existante.
     * @param noteEntity La note à sauvegarder.
     * @return L'identifiant de la note sauvegardée.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(noteEntity: NoteEntity): Long

    /**
     * Supprime une note spécifique de la base de données.
     * @param id L'identifiant de la note à supprimer.
     */
    @Query("DELETE FROM NoteEntity WHERE id=:id")
    suspend fun deleteNote(id: Long)
}