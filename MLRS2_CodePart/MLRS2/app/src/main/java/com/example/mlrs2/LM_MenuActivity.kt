package com.example.mlrs2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LM_MenuActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_menu_lm)

            val btn_makeReservation = findViewById<Button>(R.id.btn_lm_menu_make_reservation)
            val btn_listReservation = findViewById<Button>(R.id.btn_lm_menu_list_reservation)

            // click make reservation button, go to make reservation page
            btn_makeReservation.setOnClickListener {
                reDirectMakeReservationPage()
            }

            // click list reservation button, go to list reservation page
            btn_listReservation.setOnClickListener {
                reDirectListReservationPage()
            }

        }
        // list resevation for starting reservation page 1
        fun reDirectMakeReservationPage() {
            val intent = Intent(this, LM_ListLibraries_Activity::class.java)
            startActivity(intent)
            finish()
        }

        fun reDirectListReservationPage() {
            val intent = Intent(this, LM_ListReservations_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }