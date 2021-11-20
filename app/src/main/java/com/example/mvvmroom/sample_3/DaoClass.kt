package com.example.mvvmroom.sample_3

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoClass {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: NoteClass)

    @Update
    fun update(note: NoteClass)

    @Delete
    fun delete(note: NoteClass)

    @Query("SELECT * FROM note_table WHERE id = :noteId")
    fun getNote(noteId: Int): NoteClass

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<NoteClass>>
}