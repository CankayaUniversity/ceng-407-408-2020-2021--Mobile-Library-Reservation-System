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
            val ln3 = intent.getStringExtra("l2")
            val d3 = intent.getStringExtra("d1")
            val ft3 = intent.getStringExtra("ts1")
            val tableNo = 1

            val newIntent = Intent(this, Activity_LM_QR::class.java)
            //Send library name, date, time slot and table no to QR code page
            newIntent.putExtra("l4", ln3)
            newIntent.putExtra("d4", d3)
            newIntent.putExtra("fT4", ft3)
            newIntent.putExtra("tb1", tableNo.toString())
            //putExtra içinde veri string olması gerek.Değilse toString() ile çevirebiliriz.

            startActivity(newIntent)
            // qr kod da alınırsa finish yoruma al(anlamadım:Burcu)
            finish()
        }
    }
}