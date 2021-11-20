package com.example.mvvmroom.sample_3

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepo(var context: Application) {

    private var noteDao: DaoClass

    private var allNotes: LiveData<List<NoteClass>>

    init {
        val database = DatabaseClass.getInstance(context)
        noteDao = database.daoClass()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: NoteClass) = CoroutineScope(Dispatchers.IO).launch {
        noteDao.insert(note)
    }


    fun update(note: NoteClass) = CoroutineScope(Dispatchers.IO).launch {
        noteDao.update(note)
    }


    fun delete(note: NoteClass) = CoroutineScope(Dispatchers.IO).launch {
        noteDao.delete(note)
    }


    fun deleteAll() = CoroutineScope(Dispatchers.IO).launch {
        noteDao.deleteAllNotes()
    }

    fun getNote(noteId: Int) = noteDao.getNote(noteId)

    fun getAllNotes() = allNotes

}