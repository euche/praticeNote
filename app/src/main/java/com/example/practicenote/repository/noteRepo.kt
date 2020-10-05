package com.example.practicenote.repository

import com.example.practicenote.noteDao
import com.example.practicenote.model.note

class noteRepo(private val dao: noteDao) {

    val unote = dao.getallNotes()

    suspend fun insertnote(newnote: note) {

        dao.inserteveryNote(newnote)

    }

    suspend fun deletenote(note: note) {

        dao.delete(note)
    }


}