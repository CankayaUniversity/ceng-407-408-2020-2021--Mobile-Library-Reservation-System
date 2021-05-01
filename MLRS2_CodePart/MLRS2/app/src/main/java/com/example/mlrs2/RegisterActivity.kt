package com.example.mlrs2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.util.Patterns
import android.view.View
import android.content.ContentValues.TAG
import android.widget.*
import com.example.mlrs2.R.layout.activity_register
import com.example.mlrs2.R.layout.text_view_with_line_height_from_layout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.lang.Exception
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //  In order to use the assets on the design page, variables such as button, edit text have been created.
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_sign_in = findViewById<Button>(R.id.btnEmail_sign_in_button)
        val et_input_password = findViewById<EditText>(R.id.et_input_password)
        val et_input_email = findViewById<EditText>(R.id.et_input_email)
        val et_input_confirm_password = findViewById<EditText>(R.id.et_input_confirm_password)

        btn_sign_in.setOnClickListener {
            reLoginPage()
        }

        // If the user presses the button, it is checked that all fields are correctly filled.
        btn_register.setOnClickListener {

            // The correctness of the fields filled is checked. For example, the correctness of the password entered for the second time.
            if (et_input_email.text.isNotEmpty() && et_input_password.text.isNotEmpty() && et_input_confirm_password.text.isNotEmpty()) {

                if (et_input_password.text.toString().equals(et_input_confirm_password.text.toString())) {

                    //Toast.makeText(this,"Sorun yok ekleme yapılabilir",Toast.LENGTH_LONG).show()
                    registerNewEmail(et_input_email.text.toString(), et_input_password.text.toString())

                } else {
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show()
                }

            }
            // if all fields are not filled..
            else {
                Toast.makeText(this, "Please fill in the blank fields.", Toast.LENGTH_LONG).show()
            }
        }
    }
    // Check Firebase Registration
    fun registerNewEmail(email: String, password: String) {
        showProgressbar()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { v ->
            Toast.makeText(this, "Successful :" + v.isSuccessful, Toast.LENGTH_SHORT).show()

            if (v.isSuccessful) {
                Toast.makeText(this, "Session  :" + FirebaseAuth.getInstance().currentUser?.uid, Toast.LENGTH_LONG).show()

                sendVerificationEmail()

                FirebaseAuth.getInstance().signOut()
                reDirectLoginPage()


            } else {
                Toast.makeText(this, "Error! Could not add. :" + v.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
        closeProgressBar()
    }
    // Send Verification Mail of Added Account.
    fun sendVerificationEmail() {

        var user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            user?.sendEmailVerification()?.addOnCompleteListener(object : OnCompleteListener<Void> {
                override fun onComplete(p0: Task<Void>) {
                    if (p0.isSuccessful) {
                        Toast.makeText(this@RegisterActivity, "Confirmation mail has been sent, please check.", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@RegisterActivity, "Error! Mail could not be sent, please try again.", Toast.LENGTH_LONG).show()
                    }
                }

            })
        }


    }

    public fun showProgressbar() {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
    }

    public fun closeProgressBar() {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.INVISIBLE
    }

    // If user verify account with Mail, user is directed Login screen.
    fun reDirectLoginPage(){
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun reLoginPage(){
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}