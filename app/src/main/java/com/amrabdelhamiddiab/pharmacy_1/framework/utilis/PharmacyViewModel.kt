package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class PharmacyViewModel(application: Application, protected val dependencies: Interactions):
    AndroidViewModel(application) {
    protected val application : PharmacyApplication =this.getApplication()

}