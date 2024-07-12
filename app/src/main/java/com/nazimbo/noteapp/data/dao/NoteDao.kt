package com.nazimbo.noteapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nazimbo.noteapp.data.entity.NoteEntity

@Dao
internal interface NoteDao {

    @Query("SELECT * FROM NoteEntity")
    fun getNotes(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM NoteEntity WHERE id=:id")
    suspend fun getNote(id: Long): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(noteEntity: NoteEntity): Long

    @Query("DELETE FROM NoteEntity WHERE id=:id")
    suspend fun deleteNote(id: Long)
}