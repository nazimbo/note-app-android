package com.nazimbo.noteapp.data.model

/**
 * Représente un modèle de données pour une note. Utilisé pour manipuler les données des notes dans l'application.
 *
 * @property id Identifiant unique de la note.
 * @property title Titre de la note.
 * @property note Contenu de la note.
 */
data class Note(
    val id: Long = 0,
    var title: String = "",
    var note: String = ""
)