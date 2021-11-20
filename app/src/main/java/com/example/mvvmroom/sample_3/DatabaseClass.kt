package com.example.mvvmroom.sample_3

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [NoteClass::class],
    version = 1)
abstract class DatabaseClass : RoomDatabase() {

    abstract fun daoClass(): DaoClass

    companion object {
        private const val TAG = "[NoteDatabase]"
        private const val DATABASE_NAME = "note_db"
        private val LOCK = Any()
        @Volatile var instance: DatabaseClass? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(LOCK) {
                createDatabase(context)
                    .also {
                        instance = it
                    }
            }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseClass::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.d(TAG, "Db onCreate finish.")
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    Log.d(TAG, "Db onOpen.")
                }
            })
            .build()
    }
}