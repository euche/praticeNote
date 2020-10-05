package com.example.practicenote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.practicenote.model.note


@Dao
interface noteDao {

    @Query("SELECT * FROM note")
    suspend fun getallSavednotes(): List<note>

    @Query("SELECT * FROM note WHERE nid IN (:noteIds)")
    suspend fun loadAllsavednotesbyid(noteIds:IntArray):List<note>

    @Query("SELECT * FROM note")
    fun getallNotes():LiveData<List<note>>

    @Insert
    suspend fun inserteveryNote(note:note):Long

    @Delete
    suspend fun delete(usernote:note)

}