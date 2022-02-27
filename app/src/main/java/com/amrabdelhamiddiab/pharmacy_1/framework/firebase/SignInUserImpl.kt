package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.ISignInUser
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class SignInUserImpl(private val mAuth: FirebaseAuth): ISignInUser {
    override suspend fun signInUser(email: String, password: String): Boolean {
        return try {
            val authResult = mAuth.signInWithEmailAndPassword(email, password).await()
            if (authResult != null) {
                Log.d(TAG, mAuth.currentUser?.email.toString())
                true
            } else {
                Log.d(TAG, "user didn't sign in")
                false
            }
        } catch (ex: Exception) {
            Log.d(TAG, ex.message.toString())
            false
        }
    }
}