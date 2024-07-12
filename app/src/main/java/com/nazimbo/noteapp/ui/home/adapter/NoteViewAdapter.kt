package com.nazimbo.noteapp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nazimbo.noteapp.R
import com.nazimbo.noteapp.data.model.Note

class NoteViewAdapter(
    val context: Context,
    val clickDeleteListener: (Note) -> Unit,
    val clickEditListener: (Note) -> Unit,
) : ListAdapter<Note, NoteViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)

        holder.title.text = note.title
        holder.note.text = note.note
        holder.btDelete.setOnClickListener { clickDeleteListener(note) }
        holder.btEdit.setOnClickListener { clickEditListener(note) }
    }

    companion object {
        class DiffCallback : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(
                oldItem: Note,
                newItem: Note
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Note,
                newItem: Note
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}