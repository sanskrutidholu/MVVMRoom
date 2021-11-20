package com.example.mvvmroom.sample_3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteVM(application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepo = NoteRepo(application)
    private var noteList: LiveData<List<NoteClass>> = repository.getAllNotes()

    fun insertNote(note: NoteClass) = repository.insert(note)

    fun deleteNote(note: NoteClass) = repository.delete(note)

    fun updateNote(note: NoteClass) = repository.update(note)

    fun deleteAllNotes() = repository.deleteAll()

    fun getNote(noteId: Int) = repository.getNote(noteId)

    fun getAllNotes() = noteList
}