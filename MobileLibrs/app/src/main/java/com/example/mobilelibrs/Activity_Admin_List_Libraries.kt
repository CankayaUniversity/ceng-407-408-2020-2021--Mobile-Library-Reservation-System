package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder

class Activity_Admin_List_Libraries : AppCompatActivity() {

    lateinit var binding: LayoutAdminListLibrariesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Layout connection by using binding
        val binding = LayoutAdminListLibrariesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Firebase access variable
        var database = FirebaseDatabase.getInstance().reference.child("library")


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
                    sb.append("Name: $lname \n Address: $laddress \n Capacity: $lcap \n\n")
                }
                binding.AdminLibList.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)

        binding.buttonLmBack.setOnClickListener {
            reDirectBackAdminMenuPage()
        }
    }

    fun reDirectBackAdminMenuPage() {
        val intent = Intent(this, Activity_Admin_Menu::class.java)
        startActivity(intent)
        finish()
    }
}