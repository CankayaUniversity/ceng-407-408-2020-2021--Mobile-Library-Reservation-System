package com.example.mobilelibrs

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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


class Activity_Edit_Profile : AppCompatActivity() {

    private  lateinit var auth :FirebaseAuth
    var currentpassword: EditText? = null
    var newpassword: EditText? = null
    var confirmpassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =LayoutResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()

        binding.btnChangePassword.setOnClickListener(){
            changePassWord()
        }
        currentpassword =binding.etCurrentPassword as EditText
        newpassword=binding.etNewPassword as EditText
        confirmpassword=binding.etConfirmPassword as EditText
    }
    private fun changePassWord(){
        // edittext ler boş değilse
        if(currentpassword!!.text!!.isNotEmpty() && newpassword!!.text.isNotEmpty() && confirmpassword!!.text.isNotEmpty()){
            // confirmpassword eşitse newpassword
            if(newpassword!!.text.toString().equals(confirmpassword!!.text.toString())){

                val user: FirebaseUser? = auth.currentUser

                if(user!= null && user.email != null){

                    val credential:AuthCredential = EmailAuthProvider.getCredential(user.email!!, currentpassword!!.text.toString())

                    user?.reauthenticate(credential)?.addOnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(this,"Re-Authentication success",Toast.LENGTH_SHORT).show()
                                user?.updatePassword(newpassword!!.text.toString())?.addOnCompleteListener { task ->
                                        if (task.isSuccessful){
                                            Toast.makeText(this,"Password Changed Succesfully",Toast.LENGTH_SHORT).show()
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