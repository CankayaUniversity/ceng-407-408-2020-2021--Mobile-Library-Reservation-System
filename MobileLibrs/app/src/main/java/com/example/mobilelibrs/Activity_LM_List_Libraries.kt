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

    lateinit var binding4: LayoutLmListLibrariesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding1 = LayoutLmListLibrariesBinding.inflate(layoutInflater)

        setContentView(binding1.root)
        // click make reservation button, view list libraries.
        binding1.btnNextLmselecttlib.setOnClickListener(){
            reDirect_LM_Select_Date_Time_Slot()
        }
    }

    fun reDirect_LM_Select_Date_Time_Slot() {
        val intent = Intent(this, Activity_LM_Seelect_Date_and_Time_Slot::class.java)
        startActivity(intent)
        finish()
    }

}