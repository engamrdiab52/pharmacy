package com.amrabdelhamiddiab.pharmacy_1.presentation.medicines

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.core.domain.Medicine
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.Interactions
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModel
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicinesViewModel(application: Application, dependencies: Interactions) :
    PharmacyViewModel(application, dependencies) {

    private val _listOfMedicines = SingleLiveEvent<List<Medicine>?>()
    val listOfMedicines: LiveData<List<Medicine>?> get() = _listOfMedicines

    private val _downloading = SingleLiveEvent<Boolean>()
    val downloading: LiveData<Boolean> get() = _downloading

    fun downloadMedicines(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfMedicines.postValue(dependencies.downloadAllMedicines(url))
            _downloading.postValue(false)
        }
    }

}