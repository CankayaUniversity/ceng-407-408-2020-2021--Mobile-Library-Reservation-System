package com.example.mobilelibrs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Activity_LM_List_Libraries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // click make reservation button, view list libraries.
        setContentView(R.layout.layout_lm_list_libraries)
    }
}