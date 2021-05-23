package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder
import com.example.mobilelibrs.Library
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLmListReservationsBinding

class Activity_LM_List_Reservations: AppCompatActivity() {

    lateinit var binding: LayoutLmListReservationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LayoutLmListReservationsBinding.inflate(layoutInflater)
        binding.txtAreaReservations.movementMethod = ScrollingMovementMethod()

        // get db reference
        var database = FirebaseDatabase.getInstance().reference.child("reservation")
        setContentView(binding.root)




        // All data is in getData variable
        var getData = object : ValueEventListener {
            //bu method veritabanında veri varsa anında görüntülüyor
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() // convert all data as text
                for(i in snapshot.children) {
                    // path: database de tutulan değişkenin ismi
                    var libName = i.child("libName").getValue().toString()
                    sb.append("Library: $libName \n")
                    var fromtime = i.child("fromtime").getValue().toString()
                    sb.append("Time: $fromtime - ")
                    var totime= i.child("totime").getValue().toString()
                    sb.append("$totime \n")
                    var date = i.child("date").getValue().toString()
                    sb.append("Date: $date  ")
                    var tableno = i.child("tableNo").getValue().toString()
                    sb.append("Table: $tableno\n\n")
                }
                binding.txtAreaReservations.setText(sb)

            }
            override fun onCancelled(error: DatabaseError) {

            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }


}