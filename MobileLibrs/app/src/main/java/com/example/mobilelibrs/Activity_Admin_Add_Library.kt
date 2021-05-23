package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminAddLibraryBinding
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder


class Activity_Admin_Add_Library : AppCompatActivity() {

    lateinit var binding: LayoutAdminAddLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LayoutAdminAddLibraryBinding.inflate(layoutInflater)

        var database = FirebaseDatabase.getInstance().reference
        setContentView(binding.root)

        // Data writes to db
        binding.btnAddLibrary.setOnClickListener {

            var libName = binding.txtLibraryName.text.toString()
            var libAddres = binding.txtLibraryAddres.text.toString()
            var libCapacity = binding.txtLibraryCapacity.text.toString().toInt()

            // Write a message to the database
            //database.setValue(Library(libNamee, libAddress, libCapacities) )
            database.child("library").push().setValue(Library(libName, libAddres, libCapacity))
            Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()
        }

        binding.buttonAdBack.setOnClickListener {
            reDirectBackAdminMenuPage()
        }
    }

    fun reDirectBackAdminMenuPage() {
        val intent = Intent(this, Activity_Admin_Menu::class.java)
        startActivity(intent)
        finish()

    }


}