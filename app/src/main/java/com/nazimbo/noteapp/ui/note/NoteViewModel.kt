package com.nazimbo.noteapp.ui.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazimbo.noteapp.data.model.Note
import com.nazimbo.noteapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.saveNote(
                Note(
                    title = note.title,
                    note = note.note
                )
            )
        }
    }
}