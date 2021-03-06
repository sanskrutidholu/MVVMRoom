package com.example.mvvmroom.sample_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.R
import kotlinx.android.synthetic.main.s3_note_element.view.*

class NoteAdapterClass: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var notes = listOf<NoteClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.s3_note_element, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoteViewHolder -> holder.bind(notes[position])
        }
    }

    override fun getItemCount(): Int = notes.size

    fun refreshNotes(noteList: List<NoteClass>) {
        // val oldNotes = notes
        val diffComputer = NoteDiffUtils(notes, noteList)
        val diffResult = DiffUtil.calculateDiff(diffComputer)
        notes = noteList
        diffResult.dispatchUpdatesTo(this)
    }

    fun getNoteAt(position: Int) = notes[position]

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: NoteClass) = with(itemView) {
            tv_priority.text = note.priority.toString()
            tv_title.text = note.title
            tv_desc.text = note.description
        }
    }

    class NoteDiffUtils(
        var oldNotes: List<NoteClass>,
        var newNotes: List<NoteClass>
    ): DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldNotes[oldItemPosition].id == newNotes[newItemPosition].id

        override fun getOldListSize() = oldNotes.size

        override fun getNewListSize() = newNotes.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldNotes[oldItemPosition] == (newNotes[newItemPosition])
    }
}