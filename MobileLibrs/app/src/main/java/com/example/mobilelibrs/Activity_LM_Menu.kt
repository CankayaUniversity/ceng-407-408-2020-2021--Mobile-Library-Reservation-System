package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_LM_Menu  : AppCompatActivity() {

    var lmID: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_lm_menu)

        val btn_makeReservation = findViewById<Button>(R.id.btn_lm_menu_make_reservation)
        val btn_listReservation = findViewById<Button>(R.id.btn_lm_menu_list_reservation)
        val btn_exit_menu = findViewById<Button>(R.id.btn_menu_exit)

        //Show adminID in textview
        lmID = findViewById<Button>(R.id.tv_lmID)  as TextView
        val lmID1 = intent.getStringExtra("userId")
        lmID!!.setText("Library Name: "+ lmID1)


        // click make reservation button, go to make reservation page
        btn_makeReservation.setOnClickListener {
            val newIntent = Intent(this@Activity_LM_Menu, Activity_LM_List_Libraries::class.java)
            newIntent.putExtra("userId1", lmID1)
            startActivity(newIntent)
            finish()
        }

        // click list reservation button, go to list reservation page
        btn_listReservation.setOnClickListener {
            val newIntent = Intent(this@Activity_LM_Menu, Activity_LM_List_Reservations::class.java)
            newIntent.putExtra("userId1", lmID1)
            startActivity(newIntent)
            finish()
        }

        btn_exit_menu.setOnClickListener {
            reDirectLoginPage()
        }

    }

    fun reDirectLoginPage() {
        val intent = Intent(this, Activity_Login::class.java)
        startActivity(intent)
        finish()
    }

}