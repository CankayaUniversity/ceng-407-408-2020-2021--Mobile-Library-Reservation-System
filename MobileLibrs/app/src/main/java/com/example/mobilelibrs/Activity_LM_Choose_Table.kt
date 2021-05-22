package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Choose_Table : AppCompatActivity() {

    lateinit var binding: LayoutLmChooseTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding4 = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding4.root)
        var database = FirebaseDatabase.getInstance().reference


        // click make reservation button, go to qr code page.
        binding4.btnMakeReservationLastStep.setOnClickListener(){
//            reDirect_QrCodePage()

            //?????? table name binding ile çekilecek.Şimdilik elle giriyorum
            val tableNo = 1


            //?????? table name binding ile çekilecek.Şimdilik elle giriyorum
            val newIntent = Intent(this, Activity_LM_QR::class.java)
            startActivity(newIntent)
// qr kod da alınırsa finish yoruma al
            finish()
        }
    }

    fun reDirect_QrCodePage() {

    }

}