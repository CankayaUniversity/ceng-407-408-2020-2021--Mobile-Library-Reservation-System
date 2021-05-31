package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.mobilelibrs.databinding.LayoutLmListLibrariesBinding

class Activity_LM_List_Libraries : AppCompatActivity() {

    lateinit var binding: LayoutLmListLibrariesBinding


    var lmID: TextView? = null
    var spinnerArrayList = ArrayList<String>() // Creating an empty arraylist
    var database = FirebaseDatabase.getInstance().reference
    var libNameSpinner: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding to access layout
        val binding = LayoutLmListLibrariesBinding.inflate(layoutInflater)
        binding.txtAreaLiblist.movementMethod = ScrollingMovementMethod()
        setContentView(binding.root)


        //BU KISIM KÜTÜPHANE İSİMLERİ DATABASEDEN ÇEKİLECEĞİ ZAMAN KULLANILABİLİR.
        //Deneme yapıyorum..Write:Beyza
        //--

        spinnerArrayList = ArrayList<String>() // initialize
        val adapter = ArrayAdapter(this@Activity_LM_List_Libraries, android.R.layout.simple_spinner_dropdown_item, spinnerArrayList )
        binding.spinner.adapter = adapter

        var newsRef = database.child("library")
        // Db den veri çekildi, spinner array listte depolandı.
        val valueEventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (lib in dataSnapshot.children) {
                    val libName = lib.child("libraryName").getValue(String::class.java)
                    spinnerArrayList.add(libName.toString())
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("Error", databaseError.message)
            }
        }
        newsRef.addListenerForSingleValueEvent(valueEventListener)

        // spinner da seçilen veri onItemSelected içinde alındı.
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected( parent: AdapterView<*>,  view: View,  position: Int,  id: Long ) {
                libNameSpinner = spinnerArrayList[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        //--


        binding.txtAreaLiblist.setText("\n\n- LIBRARY RESERVATION RULES -\n\n" +
                "1) A maximum of 4 reservations can be made.\n\n" +
                "2) If 3 reservations are not reached, the user gets a punishmentpoint.\n\n" +
                "3) It is obligatory to scan the QR code generated at the end of the reservation to the librarian.")

        //Show lmID in textview
        lmID = binding.tvLmIDListLib  as TextView
        val lmID1 = intent.getStringExtra("userId1")
        lmID!!.setText("User"+ lmID1)

        binding.btnNext.setOnClickListener() {

            //Select a library name from spinner
//            libraryName1 = binding.spinner.selectedItem.toString()
            var libraryName1 = libNameSpinner

            //Take the library name in l1 and send it to select date and time slot page
            val newIntent = Intent(this, Activity_LM_Seelect_Date_and_Time_Slot::class.java)
            newIntent.putExtra("ln1", libraryName1)
            newIntent.putExtra("userId2", lmID1)
            // spinner array list her sayfa başladığında temizlenir.
            spinnerArrayList.clear()

            startActivity(newIntent)
            finish()
        }
    }

}