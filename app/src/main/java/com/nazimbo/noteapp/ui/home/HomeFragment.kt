package com.nazimbo.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nazimbo.noteapp.data.model.Note
import com.nazimbo.noteapp.databinding.FragmentHomeBinding
import com.nazimbo.noteapp.ui.home.adapter.NoteViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var noteViewAdapter: NoteViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setClickListeners()
        setRecyclerView()
        setObservers()

        return binding.root
    }


    private fun setClickListeners() {
        binding.fabAddNote.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNoteFragment()
            )
        }
    }

    private fun setRecyclerView() {
        // RecyclerView contenant les notes
        binding.rvNotes.layoutManager =
            GridLayoutManager(requireContext(), 2)
        noteViewAdapter = NoteViewAdapter(
            context = requireContext(),
            clickDeleteListener = this::onDeleteNoteClicked,
            clickEditListener = this::onEditNoteClicked

        )
        binding.rvNotes.adapter = noteViewAdapter
    }

    private fun setObservers() {
        viewModel.notes.observe(viewLifecycleOwner) {
            noteViewAdapter.submitList(it)
        }
    }

    private fun onDeleteNoteClicked(note: Note) {
        viewModel.deleteNote(note)
    }

    private fun onEditNoteClicked(note: Note) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToEditFragment(note.id)
        )
    }
}