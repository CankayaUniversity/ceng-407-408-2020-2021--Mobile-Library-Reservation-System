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
    var editText: EditText? = null
    var button: Button? = null
    var imageView: ImageView? = null

    var libname:TextView? =null
    var tarih:TextView? = null
    var saat:TextView? =null
    var koltuk:TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_lm_qr_code)
        editText = findViewById<View>(R.id.editText) as EditText
        button = findViewById<View>(R.id.button) as Button
        imageView = findViewById<View>(R.id.imageview) as ImageView

        libname = findViewById<View>(R.id.lname) as TextView
        tarih = findViewById<View>(R.id.tarih) as TextView
        saat = findViewById<View>(R.id.saat) as TextView  // 2 times have time from and to
        koltuk = findViewById<View>(R.id.koltuk) as TextView

        var ln4 = intent.getStringExtra("l4")
        var d4 = intent.getStringExtra("d4")
//        val ft4 = intent.getStringExtra("fT4")
//        val tt4 = intent.getStringExtra("tT4")
        var tb4 = intent.getStringExtra("tb1")


        //lib name ve saaat spinner dan alınca kontrol ederiz beraber
        libname!!.setText("Library Name: "+ ln4)
        tarih!!.setText("Date: " + d4 )
//       saat!!.setText(ft4 + " - " + tt4)
        koltuk!!.setText("Table: "+ tb4)


        button!!.setOnClickListener {


            // QR generated
            val multiFormatWriter = MultiFormatWriter()
            try {

                val bitMatrix = multiFormatWriter.encode(
                    editText!!.text.toString(),
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
}