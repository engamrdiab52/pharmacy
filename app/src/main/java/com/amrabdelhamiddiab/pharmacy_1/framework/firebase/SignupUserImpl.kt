package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.ISignupUser
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class SignupUserImpl(private val mAuth: FirebaseAuth) : ISignupUser {
    private var isUserCreated: Boolean = false
    override suspend fun signupUser(email: String, password: String): Boolean {
        return   try {
            val authResult = mAuth.createUserWithEmailAndPassword(email, password).await()
            isUserCreated = authResult.user != null
            //    mAuth.currentUser?.sendEmailVerification()?.await()
            //    isEmailVerificationSent = true
            Log.d(TAG, authResult.toString())
            Log.d(TAG, "SignUpUserImpl  : email sent")
            isUserCreated
        } catch (ex: Exception) {
            Log.d(TAG, ex.message.toString())
            isUserCreated = false
            //    isEmailVerificationSent = false
            isUserCreated
        }
    }
}