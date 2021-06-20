package com.example.mobilelibrs

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLibrarianListReservationsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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

        //All data is in getData variable
        var getData = object : ValueEventListener {
            //All data is shown if they exist
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() //Metin birleştirme sınıfı
                for (i in snapshot.children) {
                    //Path: Datebasede tutulan değişkenin ismi
                    var lname = i.child("libraryName").getValue()
                    var laddress = i.child("libraryAddress").getValue()
                    var lcap = i.child("libraryCapacity").getValue()
                    sb.append(" Name: $lname \n Address: $laddress \n Capacity: $lcap \n\n")
                }
                binding.LibrarianResList.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}