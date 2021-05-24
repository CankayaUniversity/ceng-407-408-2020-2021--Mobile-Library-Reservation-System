package com.example.mobilelibrs

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder
import com.example.mobilelibrs.databinding.LayoutLmListReservationsBinding

class Activity_LM_List_Reservations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LayoutLmListReservationsBinding.inflate(layoutInflater)
        binding.tvReservation1.movementMethod = ScrollingMovementMethod()
        binding.tvReservation2.movementMethod = ScrollingMovementMethod()
        binding.tvReservation3.movementMethod = ScrollingMovementMethod()
        binding.tvReservation4.movementMethod = ScrollingMovementMethod()
        // binding.tvReservation5.movementMethod = ScrollingMovementMethod()

        // get db reference
        val database = FirebaseDatabase.getInstance().reference.child("reservation")
        setContentView(binding.root)


        // All data is in getData variable
        var getData = object : ValueEventListener {

            //bu method veritabanında veri varsa anında görüntülüyor
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() // convert all data as text
                var j = 1

                for (i in snapshot.children) {
                    // path: database de tutulan değişkenin ismi
                    var libName = i.child("libName").getValue().toString()
                    sb.append("Library: $libName \n")
                    var fromtime = i.child("fromtime").getValue().toString()
                    sb.append("Time: $fromtime - ")
                    var totime = i.child("totime").getValue().toString()
                    sb.append("$totime \n")
                    var date = i.child("date").getValue().toString()
                    sb.append("Date: $date  ")
                    var tableno = i.child("tableNo").getValue().toString()
                    sb.append("Table: $tableno\n\n")

                    if (j == 1) {
                        binding.tvReservation1.setText(sb)
                        binding.btnCancel1.setVisibility(View.VISIBLE)
                        binding.btnQR1.setVisibility(View.VISIBLE)
                    }
                    if (j == 2 ) {
                        binding.tvReservation2.setText(sb)
                        binding.btnCancel2.setVisibility(View.VISIBLE)
                        binding.btnQR2.setVisibility(View.VISIBLE)
                    }
                    if (j == 3 ) {
                        binding.tvReservation3.setText(sb)
                        binding.btnCancel3.setVisibility(View.VISIBLE)
                        binding.btnQR3.setVisibility(View.VISIBLE)
                    }
                    if (j == 4 ) {
                        binding.tvReservation4.setText(sb)
                        binding.btnCancel4.setVisibility(View.VISIBLE)
                        binding.btnQR4.setVisibility(View.VISIBLE)
                    }
                    j++
                }
                //binding.tvReservation.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}