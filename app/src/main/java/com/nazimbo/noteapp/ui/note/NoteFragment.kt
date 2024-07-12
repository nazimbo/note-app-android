package com.nazimbo.noteapp.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nazimbo.noteapp.data.model.Note
import com.nazimbo.noteapp.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)

        setClickListeners()

        return binding.root
    }

    private fun setClickListeners() {
        binding.btAdd.setOnClickListener {
            val note =
                Note(
                    title = binding.etTitle.text.toString(),
                    note = binding.etNote.text.toString()
                )
            viewModel.addNote(note)
            findNavController().navigate(NoteFragmentDirections.actionNoteFragmentToHomeFragment())
        }
    }
}