package com.example.practicenote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practicenote.dataClient.databaseclient
import com.example.practicenote.databinding.FragmentSecondBinding
import com.example.practicenote.repository.noteRepo
import com.example.practicenote.viewmodel.NoteViewmodel
import com.example.practicenote.viewmodelfactory.noteViewmodelfactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
    private lateinit var nvm: NoteViewmodel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        //creating a dao instance
        val daoo = databaseclient.getInstance(requireActivity()).noteDao()

        //create repository instance
        val reposinstance = noteRepo(daoo)

        // viewmodelfactory instance
        val vmfactory = noteViewmodelfactory(reposinstance)

        //requireActivity() is a replacement for getContext()

        nvm = ViewModelProvider(this, vmfactory).get(NoteViewmodel::class.java)

        _binding!!.myViewModel = nvm
        _binding!!.lifecycleOwner = this



        displaynoteList()


        return view


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

//        view.findViewById<Button>(R.id.savebutton).setOnClickListener {  }


    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)
//
//
//
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun displaynoteList() {

        //write code to observe data in livedata format

        nvm.notes.observe(viewLifecycleOwner, Observer {


            Log.i("MYTAG", it.toString())
        })


    }

}