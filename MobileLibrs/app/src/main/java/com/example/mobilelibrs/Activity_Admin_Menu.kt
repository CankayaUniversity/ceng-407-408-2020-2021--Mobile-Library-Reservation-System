package com.example.mobilelibrs


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

public class Activity_Admin_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_admin_menu)

        val btn_listLibraries = findViewById<Button>(R.id.btn_admin_menu_list_libraries)
        val btn_addLibrary = findViewById<Button>(R.id.btn_admin_menu_add_library)
        val btn_exit_menu = findViewById<Button>(R.id.btn_menu_exit)
        // click list libraries button, go to libraries list page
        btn_listLibraries.setOnClickListener {
            reDirectListLibrariesPage()
        }

        // click add library button, go to add library page
        btn_addLibrary.setOnClickListener {
            reDirectAddLibraryPage()
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

    fun reDirectListLibrariesPage() {
        val intent = Intent(this, Activity_Admin_List_Libraries::class.java)
        startActivity(intent)
        finish()
    }

    fun reDirectAddLibraryPage() {
        val intent = Intent(this, Activity_Admin_Add_Library::class.java)
        startActivity(intent)
        finish()
    }

}
