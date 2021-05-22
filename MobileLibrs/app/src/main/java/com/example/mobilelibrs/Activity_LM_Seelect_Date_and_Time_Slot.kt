package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmChooseTableBinding
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Seelect_Date_and_Time_Slot : AppCompatActivity() {

    lateinit var binding: LayoutLmSelectDateAndTimeSlotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding2 = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)

        setContentView(binding2.root)
//--
        var database = FirebaseDatabase.getInstance().reference

        //if btn click, user go to Choose_Table page
        binding2.btnSearchTableNext.setOnClickListener {
//           reDirectChoose_TablePage()
     //data aldığını diğer sayfalardan görmeki için
 //--           val getLibname = intent.getStringExtra("libName")

            // binding2.txtTopic.text = getLibname

            // will send data
            val sendingDateData = binding2.etDate.text.toString()
            val sendingFromTimeData = binding2.etTimeFrom.text.toString()
            val sendingToTimeData = binding2.etTimeTo.text.toString()

//--            database.child("reservation").push().setValue(
//--                Reservation(getLibname, sendingDateData, sendingFromTimeData, sendingToTimeData, 1))


            val newIntent = Intent(this, Activity_LM_Choose_Table::class.java)

            newIntent.putExtra("date", sendingDateData)
            newIntent.putExtra("fromTime", sendingFromTimeData)
            newIntent.putExtra("toTime", sendingToTimeData)

            startActivity(newIntent)
//            finish()
        }
    }

    fun reDirectChoose_TablePage() {

    }
}