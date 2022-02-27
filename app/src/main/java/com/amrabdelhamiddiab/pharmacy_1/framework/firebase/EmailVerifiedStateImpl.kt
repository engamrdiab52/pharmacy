package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.content.Context
import android.util.Log
import com.amrabdelhamiddiab.core.data.IEmailVerifiedState
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.checkInternetConnection
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.withTimeoutOrNull

class EmailVerifiedStateImpl(private val mAuth: FirebaseAuth, private val context: Context) :
    IEmailVerifiedState {
    override suspend fun isEmailVerified(): Boolean {
        return if (checkInternetConnection(context)) {
            val result = withTimeoutOrNull(3000L) {
                mAuth.currentUser?.isEmailVerified
            }
            result ?: false
        } else {
            Log.d(TAG, "EmailVerifiesStateImpl : No Network")
            false
        }
    }
}