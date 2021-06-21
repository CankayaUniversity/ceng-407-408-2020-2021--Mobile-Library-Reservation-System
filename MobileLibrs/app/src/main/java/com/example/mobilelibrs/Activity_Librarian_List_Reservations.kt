package com.example.mobilelibrs

import android.content.Intent
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
                    //var userid = i.child("userId").getValue()
                    var lname = i.child("libName").getValue()
                    var rdate = i.child("date").getValue()
                    var rtimeslot = i.child("timeSlot").getValue()
                    var rtable = i.child("tableNo").getValue()

                    sb.append("Name: $lname \n Date: $rdate \n TimeSlot: $rtimeslot \n Table No: $rtable \n\n")
                }
                binding.LibrarianResList.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)

        binding.buttonLmBack.setOnClickListener {
            reDirectBackLibrarianMenuPage()
        }
    }

    fun reDirectBackLibrarianMenuPage() {
        val intent = Intent(this, Activity_Librarian_List_Reservations::class.java)
        startActivity(intent)
        finish()
    }
}