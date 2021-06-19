package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Activity_Librarian_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_librarian_menu)

        val btn_exit_menu = findViewById<Button>(R.id.btn_menu_exit)
        val btn_listReservation = findViewById<Button>(R.id.btn_librarian_menu_list_reservations)
        val btn_editProfile = findViewById<Button>(R.id.btn_librarian_menu_edit_profile)

        btn_exit_menu.setOnClickListener {
            reDirectLoginPage()
        }

        //Click make reservation button to go make reservation page
        btn_listReservation.setOnClickListener {
            reDirectListReservationPage()
        }

        //Click edit profile button, go to edit profile page
        btn_editProfile.setOnClickListener {
             reDirectEditProfilePage()
        }
    }

    fun reDirectListReservationPage() {
        val intent = Intent(this, Activity_Librarian_List_Reservations::class.java)
        startActivity(intent)
        finish()
    }

    fun reDirectLoginPage() {
        val intent = Intent(this, Activity_Login::class.java)
        startActivity(intent)
        finish()
    }

    fun reDirectEditProfilePage() {
    val intent = Intent(this, Activity_Edit_Profile::class.java)
         startActivity(intent)
         finish()
    }
}
