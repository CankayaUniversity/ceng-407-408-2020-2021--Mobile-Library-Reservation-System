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
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding

class Activity_LM_List_Libraries : AppCompatActivity() {

    lateinit var binding4: LayoutLmListLibrariesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding2 = LayoutLmListLibrariesBinding.inflate(layoutInflater)

        // get db reference
        var database = FirebaseDatabase.getInstance().reference.child("library")
        setContentView(binding2.root)
        // click make reservation button, view list libraries.

        //--new
        binding2.btnNextSelectDateAndTimeSlot.setOnClickListener(){

//            reDirect_LM_Select_Date_Time_Slot()
            // will send data
            val sendingData = binding2.txtEnterLibraryName.text.toString()
            val newIntent = Intent(this, Activity_LM_Seelect_Date_and_Time_Slot::class.java)
            newIntent.putExtra("libName", sendingData)
            startActivity(newIntent)
  //          finish()
        }
        //--new
       /*
        // All data is in getData variable
        var getData = object : ValueEventListener {
            //bu method veritabanında veri varsa anında görüntülüyor
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() // convert all data as text
                for(i in snapshot.children) {
                    // path: database de tutulan değişkenin ismi
                    var lname = i.child("libraryName").getValue().toString()
                    sb.append("Library Name: $lname \n\n")
                }
                binding2.txtAreaLiblist.setText(sb)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)

        var database2 = FirebaseDatabase.getInstance().reference
        binding2.btnNextLmselecttlib.setOnClickListener {
            var enter_libname = binding2.txtEnterLibraryName.text.toString()
            database2.child("reservation").push().setValue(Reservation(enter_libname))
            reDirect_LM_Select_Date_Time_Slot()

        }

        */
    }


    fun reDirect_LM_Select_Date_Time_Slot() {

    }

}