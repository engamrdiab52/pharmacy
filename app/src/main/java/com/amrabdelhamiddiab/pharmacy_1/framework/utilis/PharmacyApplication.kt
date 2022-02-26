package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import android.app.Application
import com.google.firebase.auth.FirebaseAuth


class PharmacyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val mAuth = FirebaseAuth.getInstance()
    }
}