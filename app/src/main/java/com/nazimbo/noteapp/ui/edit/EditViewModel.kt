package com.nazimbo.noteapp.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazimbo.noteapp.data.model.Note
import com.nazimbo.noteapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private val _note = MutableLiveData<Note>()
    val note: LiveData<Note>
        get() = _note

    fun getNote(id: Long) {
        // TODO
        viewModelScope.launch {
            noteRepository.getNote(id)?.let {
                _note.postValue(it)
            }
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.saveNote(note)
        }
    }
}