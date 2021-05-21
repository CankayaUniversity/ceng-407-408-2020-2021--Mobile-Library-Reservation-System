package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutLmQrCodeBinding
import com.example.mobilelibrs.databinding.LayoutLmSelectDateAndTimeSlotBinding

class Activity_LM_Seelect_Date_and_Time_Slot : AppCompatActivity() {

    lateinit var binding: LayoutLmSelectDateAndTimeSlotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding2 = LayoutLmSelectDateAndTimeSlotBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        //if btn click, user go to Choose_Table page
        binding2.btnSearchTableNext.setOnClickListener {
            reDirectChoose_TablePage()
        }
    }

    fun reDirectChoose_TablePage() {
        val intent = Intent(this, Activity_LM_Choose_Table::class.java)
        startActivity(intent)
        finish()
    }
}