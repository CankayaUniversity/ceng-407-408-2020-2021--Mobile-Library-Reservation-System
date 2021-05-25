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

        val binding4 = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding4.root)
        var database = FirebaseDatabase.getInstance().reference


        // click make reservation button, go to qr code page.
        binding4.btnMakeReservation.setOnClickListener(){
//            reDirect_QrCodePage()

            //?????? table name binding ile çekilecek.Şimdilik elle giriyorum
            var tableNo = 1

            val ln3 = intent.getStringExtra("l2")
            var d3 = intent.getStringExtra("d1")
 //           val ft3 = intent.getStringExtra("fT1")
 //           val tt3 = intent.getStringExtra("tT1")


            val newIntent = Intent(this, Activity_LM_QR::class.java)

            newIntent.putExtra("l4", ln3)
            newIntent.putExtra("d4", d3)
//            newIntent.putExtra("fT4", ft3)
//            newIntent.putExtra("tT4", tt3)
            newIntent.putExtra("tb1", tableNo.toString())
            //putExtra içinde veri string olması gerek.DEğilse toString() ile çevirebiliriz.

            startActivity(newIntent)
// qr kod da alınırsa finish yoruma al
            finish()
        }

    }


    fun reDirect_QrCodePage() {


    }

}