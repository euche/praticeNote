package com.example.practicenote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.practicenote.R
import com.example.practicenote.databinding.FragmentFirstBinding
import com.example.practicenote.databinding.NotesListItemBinding
import com.example.practicenote.generated.callback.OnClickListener
import com.example.practicenote.model.note
import kotlinx.android.synthetic.main.notes_list_item.view.*

class noteAdapter(private val noteList: List<note>,private val clickListener: (note)->Unit)    : RecyclerView.Adapter<noteAdapter.noteviewHolder>() {

    class noteviewHolder(val binding: NotesListItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        val nTitle: TextView = v.list_note_title
//        val nDate: TextView = v.list_note_date
//        val nTime: TextView = v.list_note_content

        fun bind(note: note, clickListener: (note)->Unit){

               binding.listNoteTitle.text = note.title;
               binding.listNoteContent.text = note.ncontent;
               binding.notesListItem.setOnClickListener {
                clickListener(note)

               }

        }



    }

    //viewtype is used when we want to use different types of rowLayouts in the same recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteviewHolder {

//        val itemview =
//            LayoutInflater.from(parent.context).inflate(R.layout.notes_list_item, parent, false)
//        return noteviewHolder(itemview)


        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: NotesListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.notes_list_item,parent,false)


         return noteviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: noteviewHolder, position: Int) {

//        holder.bind(noteList.get(position))
        holder.bind(noteList[position],clickListener)

    }



}