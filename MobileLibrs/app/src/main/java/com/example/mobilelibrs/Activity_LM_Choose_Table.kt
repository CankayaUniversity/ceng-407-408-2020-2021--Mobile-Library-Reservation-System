package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutDenemeBinding
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.google.firebase.database.FirebaseDatabase


class Activity_LM_Choose_Table : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding4 = LayoutDenemeBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        var libName= intent.getStringExtra("libName")

        // click make reservation button, view list libraries.
        binding4.btn.setOnClickListener(){

            //var date= intent.getStringExtra("date")
           // var timeSlot= intent.getStringExtra("timeSlot")
           // var tableno=15

            binding4.tw.text = libName


           // var database = FirebaseDatabase.getInstance().reference
           // database.child("reservation").push().setValue(Reservation(libName, date,timeSlot, tableno))
            //Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()
           // reDirectQrCodePage()

        }

    }

    fun reDirectQrCodePage() {
        val intent = Intent(this, Activity_LM_QR::class.java)
        startActivity(intent)
        finish()
    }

}