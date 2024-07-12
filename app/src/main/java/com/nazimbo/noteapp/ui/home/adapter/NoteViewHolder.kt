package com.nazimbo.noteapp.ui.home.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nazimbo.noteapp.R

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.tv_title)
    val note: TextView = view.findViewById(R.id.tv_note)
    val btDelete: ImageButton = view.findViewById(R.id.ib_delete)
    val btEdit: ImageButton = view.findViewById(R.id.ib_edit)
}