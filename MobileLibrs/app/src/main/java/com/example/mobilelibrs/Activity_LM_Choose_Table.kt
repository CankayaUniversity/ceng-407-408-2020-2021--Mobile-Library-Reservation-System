package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding

class Activity_LM_Choose_Table : AppCompatActivity() {

    lateinit var binding: LayoutLmChooseTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val binding4 = LayoutLmChooseTableBinding.inflate(layoutInflater)
        // click make reservation button, view list libraries.
        binding4.btnMakeReservationLastStep.setOnClickListener(){
            reDirect_QrCodePage()
        }
    }

    fun reDirect_QrCodePage() {
        val intent = Intent(this, Activity_LM_QR::class.java)
        startActivity(intent)
        finish()
    }

}