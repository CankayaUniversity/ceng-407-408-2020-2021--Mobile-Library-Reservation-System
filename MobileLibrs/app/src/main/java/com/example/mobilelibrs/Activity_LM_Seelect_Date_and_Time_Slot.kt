package com.example.mobilelibrs

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.Date

class Activity_LM_Seelect_Date_and_Time_Slot : AppCompatActivity() {

    var libname:TextView? =null
    var lmID: TextView? = null
    var datePicker: String? = null
    var timeslot3: String? = null

    //***Deneme 1 Haziran 2021
    var spinnerArrayList = ArrayList<String>() // Creating an empty arraylist
    var TimeSlotArrayList = ArrayList<String>()
    //***

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //-- Date Control start
        // Calendar for Date Picker
        // current datetime
        // Date control okey
        var current = LocalDate.now()
        val today = Calendar.getInstance()
        var Getdate: String? = null
        binding.datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            var sdf = SimpleDateFormat("yyyy-MM-dd")
            val month = month + 1
            datePicker = "$year-$month-$day"
            var date1: Date? = sdf.parse(datePicker.toString())
            var date2: Date? = sdf.parse(current.toString())

            if(date1!!.before(date2) || (date1!!.equals(date2)))
            {
                Toast.makeText(this, "Error date!!Please you must change.", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                Getdate = datePicker
                Toast.makeText(this, "Date okey.", Toast.LENGTH_LONG)
                    .show()
            }
        }
        //--Date control END

        //Get database reference
        var database = FirebaseDatabase.getInstance().reference


        //Take the library name in l1 and print the textview
        libname = binding.tvLibraryName as TextView
        var libraryName2 = intent.getStringExtra("ln1")
        libname!!.setText("Library Name: "+ libraryName2)

        //Show lmID in textview
        lmID = binding.tvLmIDSelectDateTimeSlot  as TextView
        var lmID2 = intent.getStringExtra("userId2")
        lmID!!.setText("User"+ lmID2)



        //***


        TimeSlotArrayList = ArrayList<String>() // initialize
        TimeSlotArrayList.add("9:00-10:00")
        TimeSlotArrayList.add("10:00-11:00")
        TimeSlotArrayList.add("11:00-12:00")

//        var timeslot3 = binding.spinnerTimeslot.selectedItem.toString()

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,  TimeSlotArrayList )
        binding.spinnerTimeslot.adapter = adapter
        // spinner da seçilen veri onItemSelected içinde alındı.
        binding.spinnerTimeslot.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long ) {
               var timeslot1 =  TimeSlotArrayList[position]
               timeslot3 = timeslot1

            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
//        database.child("dates").push().setValue(Dates(timeslot3.toString()))


        //***


        //Click button to go Choose Table page with new entries
        binding.btnSearchTable.setOnClickListener {
            //Take date and time slot to choose table page
            var date2 = Getdate
            var timeslot2 = timeslot3

            val newIntent = Intent(this, Activity_LM_Choose_Table::class.java)
            //Send these data to Choose Table page
            newIntent.putExtra("ln2", libraryName2)
            newIntent.putExtra("d2", date2)
            newIntent.putExtra("ts2", timeslot2)
            newIntent.putExtra("userId3", lmID2)
            startActivity(newIntent)
            finish()
        }
    }
}