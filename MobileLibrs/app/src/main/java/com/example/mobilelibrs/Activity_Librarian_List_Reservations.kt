package com.example.mobilelibrs

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLibrarianListReservationsBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_Librarian_List_Reservations : AppCompatActivity() {

    lateinit var binding: LayoutLibrarianListReservationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Layout connection by using binding
        val binding = LayoutLibrarianListReservationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Firebase access variable
        var database = FirebaseDatabase.getInstance().reference.child("reservation")

        binding.LibrarianResList.movementMethod = ScrollingMovementMethod()
    }
}