package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutDenemeBinding
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding

import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Choose_Table : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get database reference
        var database = FirebaseDatabase.getInstance().reference


        //Click the button to go QR code page
        binding.btnMakeReservation.setOnClickListener(){
            //Take library name, date, time slot and table no
            val libraryName3 = intent.getStringExtra("ln2")
            val date3 = intent.getStringExtra("d2")
            val timeSlot3 = intent.getStringExtra("ts2")
            val tableNo3= 1

            val newIntent = Intent(this, Activity_LM_QR::class.java)
            //Send library name, date, time slot and table no to QR code page
            newIntent.putExtra("ln4", libraryName3)
            newIntent.putExtra("d4", date3 )
            newIntent.putExtra("ts4", timeSlot3)
            newIntent.putExtra("tn4", tableNo3.toString())
            //putExtra içinde veri string olması gerek.Değilse toString() ile çevirebiliriz.

            startActivity(newIntent)
            // qr kod da alınırsa finish yoruma al(anlamadım:Burcu)
            finish()
        }
    }
}