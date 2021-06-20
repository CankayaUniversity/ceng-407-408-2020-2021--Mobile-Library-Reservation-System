package com.example.mobilelibrs

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

class Activity_LM_Choose_Table : AppCompatActivity() {

    var lmID: TextView? = null
    var libDateTimeInfo: TextView? = null

    var ExitsTableList: ArrayList<String> = ArrayList<String>()
    var SpinnerUsedTableList: ArrayList<String> = ArrayList<String>()
    var selecteed_table: String? = null

    var ttable: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmChooseTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get database reference
        var database = FirebaseDatabase.getInstance().reference

        //Take library name, date, time slot and table no
        val libraryName3 = intent.getStringExtra("ln2")
        val date3 = intent.getStringExtra("d2")
        val timeSlot3 = intent.getStringExtra("ts2")

        lmID = binding.tvLmIDChooseTable as TextView
        var lmID4 = intent.getStringExtra("userId3")
        lmID!!.setText("Library Name: "+ lmID4)

        /*------------------------------------------------------------ GET DATA -*-*-*-*-***-*
        SpinnerUsedTableList = ArrayList<String>() // initialize


        //All data is in getData variable
        var getData = object : ValueEventListener {
            //All data is shown if they exist
            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder() //Metin birleştirme sınıfı
                for (i in p0.children) {
                        var rtable = i.child("tableNo").getValue()
                        //SpinnerUsedTableList!!.add(rtable.toString())
                        ttable = rtable.toString()
                        println("Burdayımm")
                    /*       if(i.child("date").getValue().toString().equals(date3.toString()))
                        {
                            if (i.child("timeSlot").getValue().toString().equals(timeSlot3.toString()))
                            {
                                var rtable = i.child("tableNo").getValue()
                                SpinnerUsedTableList!!.add(rtable.toString())

                            }
                        }

                  */

                }
            }
            override fun onCancelled(error: DatabaseError) {}
        }


        // Spinner a boş table ları atma
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,  SpinnerUsedTableList!!)
        binding.spinnerTable.adapter = adapter
        // spinner da seçilen veri onItemSelected içinde alındı.
        binding.spinnerTable.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long ) {
                var selected_table =  SpinnerUsedTableList!![position]
                selecteed_table = SpinnerUsedTableList!![position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        //-*-*-*-**-* ------------------------------------------------------------*/

        SpinnerUsedTableList = ArrayList<String>() // initialize
        SpinnerUsedTableList.add("1")
        SpinnerUsedTableList.add("2")
        SpinnerUsedTableList.add("3")
        SpinnerUsedTableList.add("4")
        SpinnerUsedTableList.add("5")
        SpinnerUsedTableList.add("6")
        SpinnerUsedTableList.add("7")
        SpinnerUsedTableList.add("8")
        // Spinner a boş table ları atma
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,  SpinnerUsedTableList)
        binding.spinnerTable.adapter = adapter
        // spinner da seçilen veri onItemSelected içinde alındı.
        binding.spinnerTable.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long ) {
                var selected_table =  SpinnerUsedTableList[position]
                selecteed_table = selected_table
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        libDateTimeInfo = binding.tvWriteInfo as TextView
        //Print the values to the textviews
        libDateTimeInfo!!.setText("Library Name: "+libraryName3+"\nDate: "+date3+"\nTimeSlot: " + timeSlot3)

        //Click the button to go QR code page
        binding.btnMakeReservation.setOnClickListener(){

            var tableNo3 = selecteed_table

            val newIntent = Intent(this, Activity_LM_QR::class.java)
            //Send library name, date, time slot and table no to QR code page
            newIntent.putExtra("ln4", libraryName3)
            newIntent.putExtra("d4", date3 )
            newIntent.putExtra("ts4", timeSlot3)
            newIntent.putExtra("tn4", tableNo3.toString())
            newIntent.putExtra("userId4", lmID4)

            var res_id =database.child("reservation").push().key

            var a =database.child("reservation").push()
            a.setValue(Reservation(lmID4, res_id.toString() ,libraryName3, date3, timeSlot3, tableNo3.toString()))

            //putExtra içinde veri string olması gerek.Değilse toString() ile çevirebiliriz.
            startActivity(newIntent)
            finish()
        }
    }
}