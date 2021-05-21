package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding

class Activity_LM_QR : AppCompatActivity() {

    lateinit var binding: LayoutLmQrCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val binding1 = LayoutLmQrCodeBinding.inflate(layoutInflater)
        // click make reservation button, view menu of lm.
        binding1.btnBackMenu.setOnClickListener(){
            reDirectMainMenu()
        }
    }

    // Reservation finished in page. Redirect main menu.
    fun reDirectMainMenu() {
        val intent = Intent(this, Activity_LM_Menu::class.java)
        startActivity(intent)
        finish()
    }
}