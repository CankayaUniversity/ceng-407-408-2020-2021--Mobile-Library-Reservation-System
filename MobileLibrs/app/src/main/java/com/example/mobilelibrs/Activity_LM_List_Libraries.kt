package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder
import com.example.mobilelibrs.Library
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding

class Activity_LM_List_Libraries : AppCompatActivity() {

    lateinit var binding : LayoutLmListLibrariesBinding
    //var arrayLibList = ArrayList<String>()

    val binding3 = LayoutLmListLibrariesBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // click make reservation button, view list libraries.
        setContentView(R.layout.layout_lm_list_libraries)
        setContentView(binding.root)

        binding3.btnBack.setOnClickListener {
            val intent = Intent(this, Activity_LM_Menu::class.java)
            startActivity(intent)
            finish()
        }
    }

}