package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_QR : AppCompatActivity() {

    lateinit var binding: LayoutLmQrCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var database = FirebaseDatabase.getInstance().reference

        val binding1 = LayoutLmQrCodeBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        // click make reservation button, view menu of lm.
        binding1.btnBackMenu.setOnClickListener(){
            // GET DATA
            // this data from list lib.. page
            val getLibname = intent.getStringExtra("libName")
            // these 3 data from select date.. page
            val getdingDateData = intent.getStringExtra("date")
            val getFromTimeData = intent.getStringExtra("fromTime")
            val getToTimeData = intent.getStringExtra("toTime")
 //           reDirectMainMenu()

            database.child("reservation").push().setValue(
            Reservation(getLibname, getdingDateData, getFromTimeData, getToTimeData, 1))
            Toast.makeText(this, "Reservation succefully added..", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Activity_LM_Menu::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Reservation finished in page. Redirect main menu.
    fun reDirectMainMenu() {

    }
}