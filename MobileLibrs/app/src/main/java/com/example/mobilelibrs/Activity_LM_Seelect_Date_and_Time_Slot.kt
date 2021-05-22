package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding
import com.google.firebase.database.FirebaseDatabase

class Activity_LM_Seelect_Date_and_Time_Slot : AppCompatActivity() {

    lateinit var binding: LayoutLmSelectDateAndTimeSlotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding2 = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        //if btn click, user go to Choose_Table page
        binding2.btnSearchTable.setOnClickListener {
            //date bilgisini al ve choose table a gönder
            val date= binding2.etDate.text.toString()
            val yeniIntent1= Intent(this,Activity_LM_Choose_Table::class.java )

            yeniIntent1.putExtra("date",  date)
            startActivity(yeniIntent1)

            //time slot bilgisini al ve choose table a gönder
            val timeSlot= binding2.etTimeFrom.text.toString()
            val yeniIntent2= Intent(this,Activity_LM_Choose_Table::class.java )

            yeniIntent2.putExtra("timeSlot",  timeSlot)
            startActivity(yeniIntent2)

            reDirectChoose_TablePage()
        }
    }

    fun reDirectChoose_TablePage() {
        val intent = Intent(this, Activity_LM_Choose_Table::class.java)
        startActivity(intent)
        finish()
    }
}