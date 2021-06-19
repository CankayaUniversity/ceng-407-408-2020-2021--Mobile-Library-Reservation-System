/*package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminAddLibraryBinding
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder


class Activity_Admin_Add_Library : AppCompatActivity() {

    lateinit var binding: LayoutAdminAddLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LayoutAdminAddLibraryBinding.inflate(layoutInflater)

        var database = FirebaseDatabase.getInstance().reference
        setContentView(binding.root)

        //Data writes to db
        binding.btnAddLibrary.setOnClickListener {

            var libName = binding.txtLibraryName.text.toString()
            var libAddres = binding.txtLibraryAddres.text.toString()
            var libCapacity = binding.txtLibraryCapacity.text.toString().toInt()

            // Write a message to the database
            //database.setValue(Library(libNamee, libAddress, libCapacities) )
            database.child("library").push().setValue(Library(libName, libAddres, libCapacity))
            Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()
        }

        binding.buttonAdBack.setOnClickListener {
            reDirectBackAdminMenuPage()
        }
    }

    fun reDirectBackAdminMenuPage() {
        val intent = Intent(this, Activity_Admin_Menu::class.java)
        startActivity(intent)
        finish()
    }
}*/


package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminAddLibraryBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.LocalDate
import java.util.*


class Activity_Admin_Add_Library : AppCompatActivity() {

    lateinit var binding: LayoutAdminAddLibraryBinding
    var list = ArrayList<String>()
    var database = FirebaseDatabase.getInstance().reference

    init {
        val newsRef = database.child("library")


        val valueEventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                println("Evet girdim.")
                for (ds in dataSnapshot.children) {
                    val desc = ds.child("libraryName").getValue(String::class.java)
                    list.add(desc.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("Error", databaseError.message)
            }
        }
        newsRef.addListenerForSingleValueEvent(valueEventListener)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutAdminAddLibraryBinding.inflate(layoutInflater)


        setContentView(binding.root)
        var checkLibName = false


        // Data writes to db
        binding.btnAddLibrary.setOnClickListener {

            // Write a message to the database
            //database.setValue(Library(libNamee, libAddress, libCapacities) )


            var libName = binding.txtLibraryName.text.toString()
            var libAddres = binding.txtLibraryAddres.text.toString()
            var libCapacity = binding.txtLibraryCapacity.text.toString().toInt()

            println("Control checkLibName = " + checkLibName)
            println("Control LibValues = " + libName)


            if (!list.contains(libName)) {
                database.child("library").push().setValue(Library(libName, libAddres, libCapacity))
                Toast.makeText(this, "Library succefully added..", Toast.LENGTH_LONG).show()

                var dateList = Dates()

                // yarının tarihi
                var tomorrow_1 = LocalDate.now().plusDays(1)
                // bugünden 2 sonrasının tarihi
                var tomorrow_2 = LocalDate.now().plusDays(2)
                // bugünden 3 sonrasının tarihi
                var tomorrow_3 = LocalDate.now().plusDays(3)

                dateList.DateTomorrow_1 = tomorrow_1.toString()
                dateList.DateTomorrow_2 = tomorrow_2.toString()
                dateList.DateTomorrow_3 = tomorrow_3.toString()

                var timeSlotList = TimeSlots()

                timeSlotList.TimeSlot_1 = "9:00-10:00"
                timeSlotList.TimeSlot_2 = "10:00-11:00"
                timeSlotList.TimeSlot_3 = "11:00-12:00"

                var tableList = Tables()

                //  1. date timeslots tables add - start
                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_1.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_1.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_1.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_2.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_1.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_3.toString())
                    .setValue(tableList)
                //  1. date timeslots tables add - end

                //  2. date timeslots tables add - start
                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_2.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_1.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_2.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_2.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
                    .child(dateList.DateTomorrow_2.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_3.toString())
                    .setValue(tableList)
                //  2. date timeslots add - end

                //  3. date timeslots tables add - start
                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
//                    .child(dateID.toString() )
                    .child(dateList.DateTomorrow_3.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_1.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
//                    .child(dateID.toString() )
                    .child(dateList.DateTomorrow_3.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_2.toString())
                    .setValue(tableList)

                database.child("LibraryDateInformation")
                    .child(libName)  // as library id
                    .child("Dates")
//                    .child(dateID.toString() )
                    .child(dateList.DateTomorrow_3.toString() )
                    .child("TimeSlots")
                    .child(timeSlotList.TimeSlot_3.toString())
                    .setValue(tableList)
                //  3. date timeslots tables add - end



            } else {
                Toast.makeText(this, "This library name has been used before ", Toast.LENGTH_LONG)
                    .show()
            }
            reDirectBackAdminMenuPage()

        }



        binding.buttonAdBack.setOnClickListener {
            reDirectBackAdminMenuPage()
        }
    }

    fun reDirectBackAdminMenuPage() {
        val intent = Intent(this, Activity_Admin_Menu::class.java)
        startActivity(intent)
        finish()

    }


}