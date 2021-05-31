package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding

import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Choose_Table : AppCompatActivity() {

    var lmID: TextView? = null
    var libDateTimeInfo: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Take library name, date, time slot and table no
        val libraryName3 = intent.getStringExtra("ln2")
        val date3 = intent.getStringExtra("d2")
        val timeSlot3 = intent.getStringExtra("ts2")
        val tableNo3= 1

        lmID = binding.tvLmIDChooseTable as TextView
        var lmID4 = intent.getStringExtra("userId3")
        lmID!!.setText("Library Name: "+ lmID4)


        //Get database reference
        var database = FirebaseDatabase.getInstance().reference

        libDateTimeInfo = binding.tvWriteInfo as TextView
        //Print the values to the textviews
        libDateTimeInfo!!.setText("Library Name: "+libraryName3+"\nDate: "+date3+"\nTimeSlot: " + timeSlot3)

        //Click the button to go QR code page
        binding.btnMakeReservation.setOnClickListener(){

            val newIntent = Intent(this, Activity_LM_QR::class.java)
            //Send library name, date, time slot and table no to QR code page
            newIntent.putExtra("ln4", libraryName3)
            newIntent.putExtra("d4", date3 )
            newIntent.putExtra("ts4", timeSlot3)
            newIntent.putExtra("tn4", tableNo3.toString())
            newIntent.putExtra("userId4", lmID4)

            database.child("reservation").push().setValue(
            Reservation(lmID4, libraryName3, date3, timeSlot3, 1))


            //putExtra içinde veri string olması gerek.Değilse toString() ile çevirebiliriz.
            startActivity(newIntent)
            finish()
        }
    }
}