package com.example.practicenote.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicenote.repository.noteRepo
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.viewModelScope
import com.example.practicenote.model.note
import kotlinx.coroutines.launch

class NoteViewmodel(private val repos: noteRepo) : ViewModel(),Observable{

    //creating a function and a variable for inserting notes


    val notes = repos.unote


    @Bindable
    val noteTitle = MutableLiveData<String>()

    @Bindable
    val noteContent = MutableLiveData<String>()

    @Bindable
    val saveButtonCallback = MutableLiveData<String>()

    //    function to bind to view
    fun saveUpdate() {

        val Ntitle: String = noteTitle.value!!
        val Ncontent: String = noteContent.value!!


        // insert job + data class note instance
        insert(note(0, Ntitle, Ncontent))

        noteTitle.value = null
        noteTitle.value = null



    }


    // insert function using coroutines

//    fun insert(n: note){
//
//        viewModelScope.launch { this
//
//
//        repos.insertnote(n)
//        }
//
//
//    }

    // or

    // insert function using coroutines
    fun insert(n: note) = viewModelScope.launch {

        repos.insertnote(n)

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}