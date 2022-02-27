package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.content.Context
import android.util.Log
import com.amrabdelhamiddiab.core.data.IResetUserPassword
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.checkInternetConnection
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeoutOrNull

class ResetUserPasswordImpl(private val mAuth: FirebaseAuth, private val context: Context) :
    IResetUserPassword {
    override suspend fun resetPassword(email: String): Boolean {
        return if (checkInternetConnection(context)) {
            val result = withTimeoutOrNull(3000L) {
                try{
                    mAuth.sendPasswordResetEmail(email).await()
                    true
                }catch (ex: Exception){
                    Log.d(TAG, "ResetPasswordImpl : "+ ex.message.toString())
                    false
                }
            }
            result ?: false
        } else {
            Log.d(TAG,"ResetPasswordImpl : No Network")
            false
        }
    }

}