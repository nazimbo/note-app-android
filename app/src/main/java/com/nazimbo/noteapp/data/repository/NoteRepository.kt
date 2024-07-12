package com.nazimbo.noteapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.nazimbo.noteapp.data.converter.toNote
import com.nazimbo.noteapp.data.converter.toNoteEntity
import com.nazimbo.noteapp.data.dao.NoteDao
import com.nazimbo.noteapp.data.model.Note
import java.time.LocalDateTime
import javax.inject.Inject

interface NoteRepository {

    fun getNotes(): LiveData<List<Note>>

    suspend fun getNote(id: Long): Note?

    suspend fun saveNote(note: Note): Long

    suspend fun deleteNote(note: Note)
}

internal class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) :
    NoteRepository {

    override fun getNotes(): LiveData<List<Note>> =
        noteDao.getNotes().map { noteEntityList ->
            noteEntityList.map { noteEntity ->
                noteEntity.toNote()
            }
        }

    override suspend fun getNote(id: Long): Note? =
        noteDao.getNote(id)?.toNote()

    override suspend fun saveNote(note: Note): Long {
        return noteDao.saveNote(note.toNoteEntity(LocalDateTime.now()))
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note.toNoteEntity(null).id)
    }
}