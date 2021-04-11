package com.example.mlrs2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    //Firebase
    private lateinit var mAuthListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupFirebase()
        var btnEmail_sign_in_button = findViewById<Button>(R.id.btnEmail_sign_in_button)
        var etEmail = findViewById<EditText>(R.id.etEmail)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var tvlink_register = findViewById<TextView>(R.id.tvlink_register)
        var tvresend_verification_email = findViewById<TextView>(R.id.tvresend_verification_email)


        btnEmail_sign_in_button.setOnClickListener {
            if (etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty()) {

                showProgressbar()
// ybeyza.ankara@gmail.com
                FirebaseAuth.getInstance().signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                    .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                        override fun onComplete(p0: Task<AuthResult>) {
                            reDirectMainPage()
                            closeProgressBar()
                            Toast.makeText(this@LoginActivity, "Login Successful: " + p0.isSuccessful, Toast.LENGTH_SHORT).show()
                        }

                    })
                    .addOnFailureListener(object : OnFailureListener {
                        override fun onFailure(p0: Exception) {
                            Toast.makeText(this@LoginActivity, "Login Failed: " + p0.message, Toast.LENGTH_SHORT).show()
                            closeProgressBar()
                        }

                    })


            } else {
                Toast.makeText(this, "Please fill in the blank fields.", Toast.LENGTH_LONG).show()
            }
        }


        tvlink_register.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        tvresend_verification_email.setOnClickListener {
            val dialog = ResendVerificationDialog()
            dialog.show(supportFragmentManager, "dialog_resend_email_verification")
        }
    }

    //FIREBASE SETUP
    private fun setupFirebase() {

        mAuthListener = object : FirebaseAuth.AuthStateListener {

            override fun onAuthStateChanged(p0: FirebaseAuth) {
                var user = p0.currentUser

                if (user != null) {

                    if (user.isEmailVerified) {
                        Toast.makeText(this@LoginActivity, "E-mail is confirmed. : " + user.uid, Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@LoginActivity, "Please confirm your e-mail. : ", Toast.LENGTH_LONG).show()
                        FirebaseAuth.getInstance().signOut()
                    }


                } else {
                    Toast.makeText(this@LoginActivity, "EXIT WAS DONE. : ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener)
        }
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener)
    }

    public fun showProgressbar() {
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE


    }

    public fun closeProgressBar() {
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.INVISIBLE
    }

    // The user is directed from the login page to the home(main) page.
    fun reDirectMainPage(){
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}