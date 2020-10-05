@file:Suppress("UNCHECKED_CAST")

package com.example.practicenote.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicenote.repository.noteRepo
import com.example.practicenote.viewmodel.NoteViewmodel
import java.lang.IllegalArgumentException


class noteViewmodelfactory(private val repos: noteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom((NoteViewmodel::class.java))) {

            return NoteViewmodel(repos) as T

        }

        throw IllegalArgumentException("Unknown View Model Class")

    }


}