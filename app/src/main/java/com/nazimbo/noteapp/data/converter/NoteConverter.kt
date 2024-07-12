package com.nazimbo.noteapp.data.converter

import com.nazimbo.noteapp.data.entity.NoteEntity
import com.nazimbo.noteapp.data.model.Note
import java.time.LocalDateTime

/***
 * Convertisseur NoteEntity(DB) <-> Note(model)
 */

fun Note.toNoteEntity(updatedAt: LocalDateTime?) = NoteEntity(
    id = id,
    updatedAt = updatedAt,
    title = title,
    note = note
)

fun NoteEntity.toNote() = Note(
    id = id,
    title = title,
    note = note
)