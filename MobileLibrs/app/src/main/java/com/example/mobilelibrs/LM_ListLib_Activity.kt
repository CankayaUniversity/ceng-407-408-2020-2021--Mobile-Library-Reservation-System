package com.example.mobilelibrs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LM_ListLib_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // click make reservation button, view list libraries.
        setContentView(R.layout.activity_lm_listlibraries)
    }
}