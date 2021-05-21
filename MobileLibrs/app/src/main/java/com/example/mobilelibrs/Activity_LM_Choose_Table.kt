package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.google.firebase.database.FirebaseDatabase

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Activity_LM_Choose_Table : AppCompatActivity() {

    lateinit var binding: LayoutLmChooseTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding4 = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding4.root)



        // click make reservation button, view list libraries.
        binding4.btnMakeReservation.setOnClickListener(){
            val libName= intent.getStringExtra("libName")
            val date= intent.getStringExtra("date")
            val timeSlot= intent.getStringExtra("timeSlot")
            val tableno=15


            var database = FirebaseDatabase.getInstance().reference
            //database.child("reservation").push().setValue(Reservation(libName, date,timeSlot, tableno))
            //Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()
            reDirect_QrCodePage()

        }

    }

    fun reDirect_QrCodePage() {
        val intent = Intent(this, Activity_LM_QR::class.java)
        startActivity(intent)
        finish()
    }

}