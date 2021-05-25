package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        binding2.btnSearchTable.setOnClickListener {
//           reDirectChoose_TablePage()
     //data aldığını diğer sayfalardan görmeki için
 //--           val getLibname = intent.getStringExtra("libName")

            // binding2.txtTopic.text = getLibname

            // will ingDatsend data
            var ln1 = intent.getStringExtra("l1")
            var sendeData = binding2.etDate.text.toString()

            //****(***2satır) yoruma aldım(Beyza)Spinnerdan çekicez time ı.Silinecek spinner yapılınca
            //            val sendingFromTimeData = binding2.etTimeFrom.text.toString()
            //            val sendingToTimeData = binding2.etTimeTo.text.toString()

//--            database.child("reservation").push().setValue(
//--                Reservation(getLibname, sendingDateData, sendingFromTimeData, sendingToTimeData, 1))


            val newIntent = Intent(this, Activity_LM_Choose_Table::class.java)
 //spinnerdan çekilcek
            newIntent.putExtra("l2", ln1 )
            newIntent.putExtra("d1", sendeData )

            //(***2satır)bunlar spinneerdan alınacağı için silinecek yorum aldım.
  //          newIntent.putExtra("fT1", sendingFromTimeData)
  //          newIntent.putExtra("tT1", sendingToTimeData)

            startActivity(newIntent)
            finish()

        }
    }

    fun reDirectChoose_TablePage() {

    }
}