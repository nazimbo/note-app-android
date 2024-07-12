package com.nazimbo.noteapp.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nazimbo.noteapp.data.model.Note
import com.nazimbo.noteapp.databinding.FragmentEditBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private var note: Note? = null

    private val viewModel: EditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        setClickListeners()
        setObserver()

        arguments?.getLong("id")?.let {
            viewModel.getNote(it)
        }

        return binding.root
    }

    private fun setClickListeners() {
        binding.btUpdate.setOnClickListener {
            note?.let {
                it.title = binding.etTitle.text.toString()
                it.note = binding.etNote.text.toString()
                viewModel.updateNote(it)
            }
            findNavController().navigate(EditFragmentDirections.actionEditFragmentToHomeFragment())
        }
    }

    private fun setObserver() {
        viewModel.note.observe(viewLifecycleOwner) {
            note = it
            binding.etTitle.setText(it.title)
            binding.etNote.setText(it.note)
        }
    }
}