package com.example.mlrs2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_up_firstpage)

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
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun reDirectLoginPage(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}