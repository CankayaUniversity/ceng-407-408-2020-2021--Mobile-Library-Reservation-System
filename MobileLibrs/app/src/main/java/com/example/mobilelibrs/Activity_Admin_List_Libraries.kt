package com.example.mobilelibrs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.StringBuilder

class Activity_Admin_List_Libraries : AppCompatActivity() {

    lateinit var binding : LayoutAdminListLibrariesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       setContentView(R.layout.activity_admin_liblist)

        val binding2 = LayoutAdminListLibrariesBinding.inflate(layoutInflater)

        var database = FirebaseDatabase.getInstance().reference

        setContentView(binding2.root)
        // Data reads to db

        // All data is in getData variable
        var getData = object : ValueEventListener {
            //bu method veritabanında veri varsa anında görüntülüyor
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder() // metin birleştirme sınıfı
                for(i in snapshot.children) {
                    // path: datebase de tutulan değişkenin ismi
                    var lname = i.child("libraryName").getValue()
                    var laddress = i.child("libraryAddress").getValue()
                    var lcap = i.child("libraryCapacity").getValue()
                    sb.append( "${i.key}) Name: $lname \n Address: $laddress \n Capacity: $lcap \n\n")
                }
                binding2.AdminLibList.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}