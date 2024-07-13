package com.nazimbo.noteapp.data.converter

import com.nazimbo.noteapp.data.entity.NoteEntity
import com.nazimbo.noteapp.data.model.Note
import java.time.LocalDateTime

/**
 * Fournit des fonctions d'extension pour convertir entre les entités de base de données [NoteEntity] et le modèle de données [Note].
 * Ces fonctions facilitent la conversion des types lors de l'interaction avec la base de données.
 */

/**
 * Convertit une instance de [Note] (modèle de données) en [NoteEntity] (entité de base de données).
 * Utilisé lors de l'insertion ou de la mise à jour des notes dans la base de données.
 *
 * @param updatedAt La date et l'heure de la dernière mise à jour de la note, peut être null.
 * @return Une instance de [NoteEntity] prête à être utilisée avec Room.
 */
fun Note.toNoteEntity(updatedAt: LocalDateTime?) = NoteEntity(
    id = id,
    updatedAt = updatedAt,
    title = title,
    note = note
)

/**
 * Convertit une instance de [NoteEntity] (entité de base de données) en [Note] (modèle de données).
 * Utilisé lors de la récupération des notes de la base de données pour les afficher dans l'interface utilisateur.
 *
 * @return Une instance de [Note] correspondant à l'entité de base de données.
 */
fun NoteEntity.toNote() = Note(
    id = id,
    title = title,
    note = note
)