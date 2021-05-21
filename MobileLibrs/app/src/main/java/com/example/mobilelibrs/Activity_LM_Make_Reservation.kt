package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Make_Reservation : AppCompatActivity() {

    lateinit var binding1: LayoutLmListLibrariesBinding
    lateinit var binding2: LayoutLmSelectDateAndTimeSlotBinding
    lateinit var binding3: LayoutLmChooseTableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding1 = LayoutLmListLibrariesBinding.inflate(layoutInflater)
        val binding2 = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)
        val binding3 = LayoutLmChooseTableBinding.inflate(layoutInflater)

        setContentView(binding1.root)
        setContentView(binding2.root)
        setContentView(binding3.root)



        var libName=""
        var date=""
        var timeslot=""
        var tableno=0

        // Next Butona bastığında devam edecek time slot, date seçimine
        binding1.btnNextSelectDateAndTimeSlot.setOnClickListener(){
            libName = "Milli Kütüphane"
        }

        binding2.btnSearchTable.setOnClickListener(){
            date= "04.07.2020"
            timeslot="12:00-13:00"
        }

        binding3.btnMakeReservation.setOnClickListener(){
            tableno=15

            // Write values to the database
            var database = FirebaseDatabase.getInstance().reference
            database.child("reservation").push().setValue(Reservation(libName, date, timeslot, tableno))
            Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()

        }
    }
}
