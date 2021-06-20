package com.example.mobilelibrs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutLibrarianListReservationsBinding

class Activity_Librarian_List_Reservations : AppCompatActivity() {

    lateinit var binding: LayoutLibrarianListReservationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_librarian_list_reservations)
    }
}