package com.example.mvvmroom.sample_3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class NoteClass(
    var title: String,
    var description: String,
    var priority: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "Note: id:$id,  title:$title, description:$description, priority:$priority"
    }

    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass) {
            return false
        }

        other as NoteClass
        return title == other.title
                && description == other.description
                && priority == other.priority
    }

    override fun hashCode() =
        31 * 31 * 31 * id.hashCode() + 31 * 31 * title.hashCode() + 31 * description.hashCode() + priority.hashCode()

}