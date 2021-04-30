package com.example.mlrs2;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

public class Admin_MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_menu_admin)

                val btn_listLibraries = findViewById<Button>(R.id.btn_admin_menu_list_libraries)
                val btn_addLibrary = findViewById<Button>(R.id.btn_admin_menu_add_library)

                // click list libraries button, go to libraries list page
                btn_listLibraries.setOnClickListener {
                    reDirectListLibrariesPage()
                }

                // click add library button, go to add library page
                btn_addLibrary.setOnClickListener {
                    reDirectAddLibraryPage()
                }

            }

            fun reDirectListLibrariesPage() {
                val intent = Intent(this, Admin_ListLibraries_Activity::class.java)
                startActivity(intent)
                finish()
            }

            fun reDirectAddLibraryPage() {
                val intent = Intent(this, Admin_AddLibrary_Activity::class.java)
                startActivity(intent)
                finish()
            }

}
