package com.example.practicenote.dataClient

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicenote.noteDao
import com.example.practicenote.model.note


@Database(entities = [note::class],version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): noteDao

}