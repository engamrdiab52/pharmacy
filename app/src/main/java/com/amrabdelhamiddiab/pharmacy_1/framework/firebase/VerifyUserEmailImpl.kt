package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.IVerifyUserEmail
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.google.firebase.auth.FirebaseAuth

class VerifyUserEmailImpl(private val mAuth: FirebaseAuth) : IVerifyUserEmail {
    override suspend fun verifyUserEmail() {
        try {
            if (mAuth.currentUser != null) {
                if (mAuth.currentUser!!.isEmailVerified) {
                    Log.d(TAG, "User Email Verified")
                } else {
                    Log.d(TAG, "Please verify Email")
                }
            } else {
                Log.d(TAG, "NO users signed in")
            }
        } catch (ex: Exception) {
            Log.d(TAG, ex.message.toString())
        }
    }
}