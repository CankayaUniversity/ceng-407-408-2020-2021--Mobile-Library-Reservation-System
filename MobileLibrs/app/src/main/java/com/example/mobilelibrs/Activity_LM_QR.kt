package com.example.mobilelibrs

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder


class  Activity_LM_QR : AppCompatActivity() {
    var editText: EditText? = null
    var button: Button? = null
    var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_lm_qr_code)
        editText = findViewById<View>(R.id.edittext) as EditText
        button = findViewById<View>(R.id.button) as Button
        imageView = findViewById<View>(R.id.imageview) as ImageView
        button!!.setOnClickListener {
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