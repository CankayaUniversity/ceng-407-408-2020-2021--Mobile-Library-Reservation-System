package com.example.mobilelibrs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.ActivityAdminAddlibraryBinding
import com.example.mobilelibrs.databinding.ActivityAdminLiblistBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder


class AdminAddLibraryActivity : AppCompatActivity() {

    var libraryNum = 0;
    lateinit var binding: ActivityAdminAddlibraryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = ActivityAdminAddlibraryBinding.inflate(layoutInflater)

        var database = FirebaseDatabase.getInstance().reference
        setContentView(binding.root)

        // Data writes to db
        binding.btnAddLibrary.setOnClickListener {

            var libNamee = binding.txtLibraryName.text.toString()
            var libAddress = binding.txtLibraryAddres.text.toString()
            var libCapacities = binding.txtLibraryCapacity.text.toString().toInt()
            libraryNum++
            // Write a message to the database
//          database.setValue(Library(libNamee, libAddress, libCapacities) )
            database.child(libraryNum.toString()).setValue(Library(libNamee, libAddress, libCapacities))
            Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()
        }

    }
}