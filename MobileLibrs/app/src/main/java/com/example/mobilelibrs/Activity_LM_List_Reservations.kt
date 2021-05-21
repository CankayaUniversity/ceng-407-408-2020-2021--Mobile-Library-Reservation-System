package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmListReservationsBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding

class Activity_LM_List_Reservations : AppCompatActivity() {

    lateinit var binding: LayoutLmListReservationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding1 = LayoutLmListReservationsBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        // click make reservation button, view menu of lm.
        binding1.btnBack.setOnClickListener(){
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