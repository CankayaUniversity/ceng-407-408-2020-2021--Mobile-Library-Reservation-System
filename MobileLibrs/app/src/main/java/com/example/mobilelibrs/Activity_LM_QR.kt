package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding

class Activity_LM_QR : AppCompatActivity() {

    lateinit var binding1: LayoutLmQrCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding1 = LayoutLmQrCodeBinding.inflate(layoutInflater)
        // click make reservation button, view list libraries.
        setContentView(binding1.root)

        // Reservation finished in page. Redirect main menu.
        binding1.btnBackMenu.setOnClickListener(){
            reDirectMainMenu()
        }
    }

    fun reDirectMainMenu() {
        val intent = Intent(this, Activity_LM_Menu::class.java)
        startActivity(intent)
        finish()
    }
}