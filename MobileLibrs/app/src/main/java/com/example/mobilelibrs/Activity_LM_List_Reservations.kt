package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder
import com.example.mobilelibrs.databinding.LayoutLmListReservationsBinding

class Activity_LM_List_Reservations : AppCompatActivity() {
    var libName: String=""
    var date:String=""
    var timeSlot:String=""
    var tableNo:String=""
    var lmID: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LayoutLmListReservationsBinding.inflate(layoutInflater)

        //Reservation info will be shown here
        binding.tvReservation1.movementMethod = ScrollingMovementMethod()
        binding.tvReservation2.movementMethod = ScrollingMovementMethod()
        binding.tvReservation3.movementMethod = ScrollingMovementMethod()
        binding.tvReservation4.movementMethod = ScrollingMovementMethod()

        //Show lmID in textview
        lmID = binding.tvLmIDResList as TextView
        var lmID2 = intent.getStringExtra("userId1")
        lmID!!.setText("User"+ lmID2)

        //Get DB Reference
        val database = FirebaseDatabase.getInstance().reference.child("reservation")
        setContentView(binding.root)


        //All data is in getData variable
        val getData = object : ValueEventListener {

            //bu method veritabanında veri varsa anında görüntülüyor
            override fun onDataChange(snapshot: DataSnapshot) {
                val sb = StringBuilder() // convert all data as text
                val sb2 = StringBuilder()
                val sb3 = StringBuilder()
                val sb4 = StringBuilder()

                var j = 1

                for (i in snapshot.children) {

                    //Buraya res id gelecek


                    // get information from db
                    libName = i.child("libName").getValue().toString()
                    timeSlot = i.child("timeSlot").getValue().toString()
                    date = i.child("date").getValue().toString()
                    tableNo = i.child("tableNo").getValue().toString()

                    // Hepsinin bilgilerini ayri text adında birleştirdim:BY
                    if(j==1)
                    {
                        sb.append("Library: $libName \nTime: $timeSlot\nDate: $date \nTable: $tableNo")
                    }
                    else if(j==2)
                    {
                        sb2.append("Library: $libName \nTime: $timeSlot\nDate: $date \nTable: $tableNo")
                    }
                    else if(j==3)
                    {
                        sb3.append("Library: $libName \nTime: $timeSlot\nDate: $date \nTable: $tableNo")
                    }
                    else if(j==4)
                    {
                        sb4.append("Library: $libName \nTime: $timeSlot\nDate: $date \nTable: $tableNo")
                    }

                    //Max 4 reservation added
                    if (j == 1) {
                        binding.tvReservation1.setText(sb)
                        binding.btnCancel1.setVisibility(View.VISIBLE)
                        binding.btnQR1.setVisibility(View.VISIBLE)
                    }
                    if (j == 2) {
                        binding.tvReservation2.setText(sb2)
                        binding.btnCancel2.setVisibility(View.VISIBLE)
                        binding.btnQR2.setVisibility(View.VISIBLE)
                    }
                    if (j == 3) {
                        binding.tvReservation3.setText(sb3)
                        binding.btnCancel3.setVisibility(View.VISIBLE)
                        binding.btnQR3.setVisibility(View.VISIBLE)
                    }
                    if (j == 4) {
                        binding.tvReservation4.setText(sb4)
                        binding.btnCancel4.setVisibility(View.VISIBLE)
                        binding.btnQR4.setVisibility(View.VISIBLE)
                    }
                    j++
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)

        //QR CODE DETAILS PAGE
        binding.btnQR1.setOnClickListener(){
            val newIntent = Intent(this@Activity_LM_List_Reservations, Activity_LM_QR::class.java)
            newIntent.putExtra("userId4", lmID2)
            newIntent.putExtra("ln4", libName)
            newIntent.putExtra("d4", date)
            newIntent.putExtra("ts4", timeSlot)
            newIntent.putExtra("tn4", tableNo)
            startActivity(newIntent)
            finish()
        }

        binding.btnQR2.setOnClickListener(){
            val newIntent = Intent(this@Activity_LM_List_Reservations, Activity_LM_QR::class.java)
            newIntent.putExtra("userId4", lmID2)
            newIntent.putExtra("ln4", libName)
            newIntent.putExtra("d4", date)
            newIntent.putExtra("ts4", timeSlot)
            newIntent.putExtra("tn4", tableNo)
            startActivity(newIntent)
            finish()
        }

        binding.btnQR3.setOnClickListener(){
            val newIntent = Intent(this@Activity_LM_List_Reservations, Activity_LM_QR::class.java)
            newIntent.putExtra("userId4", lmID2)
            newIntent.putExtra("ln4", libName)
            newIntent.putExtra("d4", date)
            newIntent.putExtra("ts4", timeSlot)
            newIntent.putExtra("tn4", tableNo)
            startActivity(newIntent)
            finish()
        }

        binding.btnQR4.setOnClickListener(){
            val newIntent = Intent(this@Activity_LM_List_Reservations, Activity_LM_QR::class.java)
            newIntent.putExtra("userId4", lmID2)
            newIntent.putExtra("ln4", libName)
            newIntent.putExtra("d4", date)
            newIntent.putExtra("ts4", timeSlot)
            newIntent.putExtra("tn4", tableNo)
            startActivity(newIntent)
            finish()
        }
        binding.btnCancel1.setOnClickListener(){
            //Buraya res id gelecek

            binding.tvReservation1.setText("")
            binding.btnCancel1.setVisibility(View.INVISIBLE)
            binding.btnQR1.setVisibility(View.INVISIBLE)
        }
        binding.btnCancel2.setOnClickListener(){
            binding.tvReservation2.setText("")
            binding.btnCancel2.setVisibility(View.INVISIBLE)
            binding.btnQR2.setVisibility(View.INVISIBLE)

        }
        binding.btnCancel3.setOnClickListener(){
            binding.tvReservation3.setText("")
            binding.btnCancel3.setVisibility(View.INVISIBLE)
            binding.btnQR3.setVisibility(View.INVISIBLE)

        }
        binding.btnCancel4.setOnClickListener(){
            binding.tvReservation4.setText("")
            binding.btnCancel4.setVisibility(View.INVISIBLE)
            binding.btnQR4.setVisibility(View.INVISIBLE)

        }

    }
}