package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Seelect_Date_and_Time_Slot : AppCompatActivity() {

    var libname:TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //Binding to access layout
        val binding = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        libname = binding.tvLibraryName as TextView

        //Get database reference
        var database = FirebaseDatabase.getInstance().reference

        //Take the library name in l1 and print the textview
        var ln1 = intent.getStringExtra("l1")
        libname!!.setText("Library Name: "+ ln1)

        //Click button to go Choose Table page with new entries
        binding.btnSearchTable.setOnClickListener {
            //Take date and time slot to choose table page
            var d1 = binding.etDate.text.toString()
            var ts1 = binding.spinnerTimeslot.selectedItem.toString()

            //database.child("reservation").push().setValue(
            //Reservation(getLibname, sendingDateData, sendingFromTimeData, sendingToTimeData, 1))

            val newIntent = Intent(this, Activity_LM_Choose_Table::class.java)
            //Send these data to Choose Table page
            newIntent.putExtra("l2", ln1)
            newIntent.putExtra("d1", d1)
            newIntent.putExtra("ts1", ts1)
            startActivity(newIntent)
            finish()
        }
    }
}