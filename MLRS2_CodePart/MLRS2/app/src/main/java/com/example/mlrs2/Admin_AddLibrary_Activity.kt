package com.example.mlrs2

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mlrs2.databinding.ActivityAdminListlibrariesBinding
import com.example.mlrs2.databinding.ActivityMenuAdminBinding
import com.example.mlrs2.databinding.AdminAddLibraryPageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Admin_AddLibrary_Activity : AppCompatActivity() {

    lateinit var binding: AdminAddLibraryPageBinding

    //var libraryNum = 0;
    //var database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.admin_add_library_page)


        val binding = AdminAddLibraryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        binding.btnAddLibrary.setOnClickListener {

        var libNamee = binding.txtLibraryName.text.toString()
        var libAddress = binding.txtLibraryAddres.text.toString()
        var libCapacities = binding.txtLibraryCapacity.text.toString().toInt()
  //      libraryNum++

            database.setValue(Library(libNamee, libAddress, libCapacities) )
            Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()

            //     database.child(libraryNum.toString()).setValue(Library(libNamee, libAddress, libCapacities))


        }


    }

}