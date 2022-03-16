package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.Interactions
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PairMediatorLiveData
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModel
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application, dependencies: Interactions) :
    PharmacyViewModel(application, dependencies) {
    private val _listOfHomeScreenItems = SingleLiveEvent<List<HomeScreenItem>?>()
    val listOfHomeScreenItems: LiveData<List<HomeScreenItem>?> get() = _listOfHomeScreenItems

    private val _downloading = SingleLiveEvent<Boolean>()
    val downloading: LiveData<Boolean> get() = _downloading

    fun downloadOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfHomeScreenItems.postValue(dependencies.downloadHomeScreenItems())
            _downloading.postValue(false)
        }
    }
    fun downloadHomeScreenItems() {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfHomeScreenItems.postValue(dependencies.downloadHomeScreenItems())
            _downloading.postValue(false)
        }
    }
   /* fun downloadHomeContents() {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            Log.d(TAG, "Before")
            val a = dependencies.downloadImagesOfSlider()
            val b = dependencies.downloadOffers()
            Log.d(TAG, "After1..${a?.size}............${b?.size}")
            _listOfOfImagesOfSlider.postValue(a)
            _listOfOffers.postValue(b)
           // Log.d(TAG, "After2..${a?.size}............${b?.size}")
            _downloading.postValue(false)
            Log.d(TAG, "After3..${a?.size}............${b?.size}")
        }
    }*/
}