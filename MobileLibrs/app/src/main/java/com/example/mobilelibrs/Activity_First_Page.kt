package com.example.mobilelibrs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Activity_First_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_first_page)

        val btn_login = findViewById<Button>(R.id.btn_add_library)
        val btn_signup = findViewById<Button>(R.id.btnEmail_sign_up_button)

        btn_login.setOnClickListener {
            reDirectLoginPage()
        }

        btn_signup.setOnClickListener {
            reDirectSignUpPage()
        }

    }

    fun reDirectSignUpPage(){
        val intent = Intent(this, Activity_Register::class.java)
        startActivity(intent)
        finish()
    }

    fun reDirectLoginPage(){
        val intent = Intent(this, Activity_Login::class.java)
        startActivity(intent)
        finish()
    }
}