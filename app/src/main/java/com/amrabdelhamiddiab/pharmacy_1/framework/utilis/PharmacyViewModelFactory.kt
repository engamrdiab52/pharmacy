package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object PharmacyViewModelFactory : ViewModelProvider.Factory {
    lateinit var application: Application
     lateinit var dependencies: Interactions

    fun inject(application: Application, dependencies: Interactions) {
        PharmacyViewModelFactory.application = application
        PharmacyViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (PharmacyViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                Application::class.java,
                Interactions::class.java
            ).newInstance(application, dependencies)
        } else {
            throw IllegalStateException("viewModel must extend BagsViewModel")
        }
    }

}