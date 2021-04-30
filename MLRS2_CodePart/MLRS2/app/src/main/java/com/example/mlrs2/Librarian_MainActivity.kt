package com.example.mlrs2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Librarian_MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_menu_librarian)

                val btn_listReservation = findViewById<Button>(R.id.btn_librarian_menu_list_reservations)
//              val btn_editProfile = findViewById<Button>(R.id.btn_librariam_menu_edit_profile)

                // click make reservation button, go to make reservation page
                btn_listReservation.setOnClickListener {
                    reDirectListReservationPage()
                }

/*                // click edit profile button, go to edit profile page
                btn_editProfile.setOnClickListener {
                    reDirectEditProfilePage()
                }
*/
            }

            fun reDirectListReservationPage() {
                val intent = Intent(this, Librarian_ListReservations_Activity::class.java)
                startActivity(intent)
                finish()
            }
/*
            fun  reDirectEditProfilePage() {
                val intent = Intent(this, Librarian_EditProfile_Activity::class.java)
                startActivity(intent)
                finish()
            }
*/
}
