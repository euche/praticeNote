package com.example.practicenote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicenote.adapter.noteAdapter
import com.example.practicenote.dataClient.databaseclient
import com.example.practicenote.databinding.FragmentFirstBinding
import com.example.practicenote.model.note
import com.example.practicenote.repository.noteRepo
import com.example.practicenote.viewmodel.NoteViewmodel
import com.example.practicenote.viewmodelfactory.noteViewmodelfactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    private var _binding: FragmentFirstBinding? = null
    private lateinit var fnvm: NoteViewmodel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        //creating a dao instance
        val dao = databaseclient.getInstance(requireActivity()).noteDao()

        //create repository instance
        val reposinstance = noteRepo(dao)

        // viewmodelfactory instance
        val vmfactory = noteViewmodelfactory(reposinstance)

        //requireActivity() is a replacement for getContext()

        fnvm = ViewModelProvider(this, vmfactory).get(NoteViewmodel::class.java)

        _binding!!.myfirstfragViewModel = fnvm
        _binding!!.lifecycleOwner = this

        initRecyclerview()




        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }


    private fun displaynoteList() {

        //write code to observe data in livedata format

        fnvm.notes.observe(viewLifecycleOwner, Observer {

            Log.i("MYTAG", it.toString())

            //binding  data to adapter--we are using a Lambda Expression or Higher Order Functions for Click event in the recyclerview.
            binding.notesList.adapter = noteAdapter(it) { selectedItem: note ->
                notelistItemclicked(
                    selectedItem
                )
            }


//            //binding  data to adapter
//            binding.notesList.adapter = noteAdapter(it)


        })


    }


    private fun initRecyclerview() {

        binding.notesList.layoutManager = LinearLayoutManager(requireActivity())
        displaynoteList()

    }


    private fun notelistItemclicked(note: note){

        Toast.makeText(requireContext(),"selected note is ${note.title}",Toast.LENGTH_SHORT).show();

    }







}