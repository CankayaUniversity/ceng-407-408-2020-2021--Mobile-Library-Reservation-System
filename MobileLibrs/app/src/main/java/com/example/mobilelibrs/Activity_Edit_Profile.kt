package com.example.mobilelibrs

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelibrs.databinding.LayoutAdminListLibrariesBinding
import com.example.mobilelibrs.databinding.LayoutResetPasswordBinding
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase


class Activity_Edit_Profile : AppCompatActivity() {

    private  lateinit var auth :FirebaseAuth
    var currentpassword: EditText? = null
    var newpassword: EditText? = null
    var confirmpassword: EditText? = null
    var btnChangePassword: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Access to layout
        setContentView(R.layout.layout_reset_password)

        // initialized variable
        auth = FirebaseAuth.getInstance()

        btnChangePassword = findViewById<View>(R.id.btn_change_password) as Button
        currentpassword = findViewById<View>(R.id.et_current_password) as EditText
        newpassword = findViewById<View>(R.id.et_new_password) as EditText
        confirmpassword = findViewById<View>(R.id.et_confirm_password) as EditText


        btnChangePassword!!.setOnClickListener(){
            changePassWord()
        }

    }

    private fun changePassWord(){
        val lbID1 = intent.getStringExtra("userId1")
        //Get database reference
        var database = FirebaseDatabase.getInstance().reference

        if(currentpassword!!.text!!.isNotEmpty()&& newpassword!!.text.isNotEmpty()&& confirmpassword!!.text.isNotEmpty()){

            if(newpassword!!.text.toString().equals(confirmpassword!!.text.toString())){

                val user:FirebaseUser?=auth.currentUser
                if(user!=null && user.email !=null){
                    val credential:AuthCredential = EmailAuthProvider.getCredential(user.email!!,
                        currentpassword!!.text.toString())
                    user?.reauthenticate(credential)
                        ?.addOnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(this,"Re-Authentication succes",Toast.LENGTH_SHORT).show()
                                user?.updatePassword(newpassword!!.text.toString())
                                    ?.addOnCompleteListener { task ->
                                        if (task.isSuccessful){
                                            Toast.makeText(this,"Password Changed Succesfully",Toast.LENGTH_SHORT).show()

//                                           database.child("user").child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(User(123457))

                                            auth.signOut()
                                            startActivity(Intent(this,Activity_Login::class.java))
                                            finish()
                                        }
                                    }
                            }
                            else{
                                Toast.makeText(this,"Re-Authentication failed",Toast.LENGTH_SHORT).show()
                            }
                        }
                } else{
                    startActivity(Intent(this,Activity_Login::class.java))
                    finish()
                }
            }
            else{
                Toast.makeText(this,"Password mismatching",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this,"Please enter all the fields",Toast.LENGTH_SHORT).show()
        }
    }
}