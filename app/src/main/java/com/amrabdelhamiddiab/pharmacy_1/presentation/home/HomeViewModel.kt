package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.Interactions
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModel
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application, dependencies: Interactions) :
    PharmacyViewModel(application, dependencies) {
    private val _listOfOffers = SingleLiveEvent<List<Offer>?>()
    val listOfOffers: LiveData<List<Offer>?> get() = _listOfOffers

    private val _downloading = SingleLiveEvent<Boolean>()
    val downloading: LiveData<Boolean> get() = _downloading

    fun downloadOffers(){
        viewModelScope.launch(Dispatchers.IO){
            _downloading.postValue(true)
            _listOfOffers.postValue(dependencies.downloadOffers())
            _downloading.postValue(false)
        }
    }
}