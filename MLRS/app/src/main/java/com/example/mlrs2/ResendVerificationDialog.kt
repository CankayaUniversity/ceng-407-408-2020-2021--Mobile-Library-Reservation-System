package com.example.mlrs2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class ResendVerificationDialog : DialogFragment() {

    //widgets
    private var mConfirmPassword: EditText? = null
    private var mConfirmEmail: EditText? = null

    //vars
    private var mContext: Context? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.dialog_resend_verification, container, false)
        mConfirmPassword = view.findViewById<View>(R.id.confirm_password) as EditText
        mConfirmEmail = view.findViewById<View>(R.id.confirm_email) as EditText
        mContext = activity


        val confirmDialog = view.findViewById<View>(R.id.dialogConfirm) as TextView
        confirmDialog.setOnClickListener {
            Log.d(TAG, "onClick: attempting to resend verification email.")

            if (!isEmpty(mConfirmEmail!!.text.toString()) && !isEmpty(mConfirmPassword!!.text.toString())) {

                //temporarily authenticate and resend verification email
                authenticateAndResendEmail(mConfirmEmail!!.text.toString(),
                        mConfirmPassword!!.text.toString())
            } else {
                Toast.makeText(mContext, "all fields must be filled out", Toast.LENGTH_SHORT).show()
            }
        }

        // Cancel button for closing the dialog
        val cancelDialog = view.findViewById<View>(R.id.dialogCancel) as TextView
        cancelDialog.setOnClickListener { dialog?.dismiss() }

        return view
    }


    /**
     * reauthenticate so we can send a verification email again
     * @param email
     * @param password
     */
    private fun authenticateAndResendEmail(email: String, password: String) {
        val credential = EmailAuthProvider
                .getCredential(email, password)
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "onComplete: Reauthenticate success.")
                        sendVerificationEmail()
                        FirebaseAuth.getInstance().signOut()
                        dialog?.dismiss()
                    }
                }.addOnFailureListener {
                    Toast.makeText(mContext, "Invalid Credentials. \nReset your password and try again", Toast.LENGTH_SHORT).show()
                    dialog?.dismiss()
                }
    }

    /**
     * sends an email verification link to the user
     */
    fun sendVerificationEmail() {
        val user = FirebaseAuth.getInstance().currentUser

        user?.sendEmailVerification()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(mContext, "Sent Verification Email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(mContext, "Couldn't send email", Toast.LENGTH_SHORT).show()
            }
        }

    }

    /**
     * Return true if the @param is null
     * @param string
     * @return
     */
    private fun isEmpty(string: String): Boolean {
        return string == ""
    }

    companion object {

        private val TAG = "ResendVerificationDialog"
    }

}