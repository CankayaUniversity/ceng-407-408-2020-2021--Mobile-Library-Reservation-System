package com.example.mobilelibrs


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

public class Activity_Admin_Menu : AppCompatActivity() {

    var adminID: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_admin_menu)

        val btn_listLibraries = findViewById<Button>(R.id.btn_admin_menu_list_libraries)
        val btn_addLibrary = findViewById<Button>(R.id.btn_admin_menu_add_library)
        val btn_exit_menu = findViewById<Button>(R.id.btn_menu_exit)
        adminID = findViewById<Button>(R.id.tv_adminID)  as TextView

        var adminID1 = intent.getStringExtra("admin1")
        adminID!!.setText("Library Name: "+ adminID1)

        //Click list libraries button, go to libraries list page
        btn_listLibraries.setOnClickListener {
            reDirectListLibrariesPage()
        }

        //Click add library button, go to add library page
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
