package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder
import com.example.mobilelibrs.Library
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Activity_LM_List_Libraries : AppCompatActivity() {

    var lmID: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmListLibrariesBinding.inflate(layoutInflater)
        binding.txtAreaLiblist.movementMethod = ScrollingMovementMethod()
        setContentView(binding.root)

        //Show lmID in textview
        lmID = binding.tvLmIDListLib  as TextView
        val lmID1 = intent.getStringExtra("userId1")
        lmID!!.setText("User"+ lmID1)

        //Get database reference
        val database = FirebaseDatabase.getInstance().reference.child("library")


        binding.btnNext.setOnClickListener() {
            //Select a library name from spinner
            var libraryName1 = binding.spinner.selectedItem.toString()

            //Take the library name in l1 and send it to select date and time slot page
            val newIntent = Intent(this, Activity_LM_Seelect_Date_and_Time_Slot::class.java)
            newIntent.putExtra("ln1", libraryName1)
            newIntent.putExtra("userId2", lmID1)
            startActivity(newIntent)
            finish()
        }

        //BU KISIM KÜTÜPHANE İSİMLERİ DATABASEDEN ÇEKİLECEĞİ ZAMAN KULLANILABİLİR.
        //All data is in getData variable
         var getData = object : ValueEventListener {
            //All data is shown if they exist
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()  //Convert all data as text
                for (i in snapshot.children) {
                    //Path: Databasede tutulan değişkenin ismi
                    var lname = i.child("libraryName").getValue().toString()
                    sb.append("Library Name: $lname \n\n")
                }
                binding.txtAreaLiblist.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}