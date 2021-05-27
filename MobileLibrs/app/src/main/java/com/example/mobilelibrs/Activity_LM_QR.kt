package com.example.mobilelibrs

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder


class Activity_LM_QR : AppCompatActivity() {
    //Create attributes to show library name, date, time slot
    //table no and QR code
    var tvqrinfo: TextView? = null
    var button: Button? = null
    var imageView: ImageView? = null

    var libname: TextView? = null
    var tarih: TextView? = null
    var saat: TextView? = null
    var koltuk: TextView? = null
    var lmID: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Access to layout
        setContentView(R.layout.layout_lm_qr_code)

        tvqrinfo = findViewById<View>(R.id.tv_qr_info) as TextView
        imageView = findViewById<View>(R.id.imageview) as ImageView

        libname = findViewById<View>(R.id.lname) as TextView
        tarih = findViewById<View>(R.id.tarih) as TextView
        saat = findViewById<View>(R.id.saat) as TextView
        koltuk = findViewById<View>(R.id.koltuk) as TextView
        lmID = findViewById<View>(R.id.tv_lmID_qr_code) as TextView

        val libraryName5 = intent.getStringExtra("ln4")
        val date5 = intent.getStringExtra("d4")
        val timeSlot5 = intent.getStringExtra("ts4")
        val tableNo5 = intent.getStringExtra("tn4")
        val lmID5 = intent.getStringExtra("userId4")

        //Print the values to the textviews
        libname!!.setText("Library Name: " + libraryName5)
        tarih!!.setText("Date: " + date5)
        saat!!.setText("TimeSlot: " + timeSlot5)
        koltuk!!.setText("Table: " + tableNo5)
        lmID!!.setText("Library Name: "+ lmID5)
        tvqrinfo!!.setText(libraryName5 + date5 + timeSlot5 + tableNo5)


        // QR generated
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(
                tvqrinfo!!.text.toString(),
                BarcodeFormat.QR_CODE,
                500,
                500
            )
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            imageView!!.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}