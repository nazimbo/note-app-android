package com.nazimbo.noteapp.data.model

/**
 * Model métier Note
 */

data class Note(
    val id: Long = 0,
    var title: String = "",
    var note: String = ""
)