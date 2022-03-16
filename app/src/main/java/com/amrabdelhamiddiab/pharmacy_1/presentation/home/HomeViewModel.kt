package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.Interactions
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PharmacyViewModel
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application, dependencies: Interactions) :
    PharmacyViewModel(application, dependencies) {
    private val _buttonMedicineClicked = SingleLiveEvent<Boolean>()
    val buttonMedicineClicked: LiveData<Boolean> get() = _buttonMedicineClicked

    private val _buttonHealthClicked = SingleLiveEvent<Boolean>()
    val buttonHealthClicked: LiveData<Boolean> get() = _buttonHealthClicked

    private val _buttonAccessoriesClicked = SingleLiveEvent<Boolean>()
    val buttonAccessoriesClicked: LiveData<Boolean> get() = _buttonAccessoriesClicked

    private val _buttonBeautyCareClicked = SingleLiveEvent<Boolean>()
    val buttonBeautyCareClicked: LiveData<Boolean> get() = _buttonBeautyCareClicked

    private val _buttonPersonalCareClicked = SingleLiveEvent<Boolean>()
    val buttonPersonalCareClicked: LiveData<Boolean> get() = _buttonPersonalCareClicked

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

    fun buttonGoToMedicines() {
        _buttonMedicineClicked.value = true
    }

    fun buttonGoToHealth() {
        _buttonHealthClicked.value = true
    }

    fun buttonGoToBeautyCare() {
        _buttonPersonalCareClicked.value = true
    }

    fun buttonGoToAccessories() {
        _buttonAccessoriesClicked.value = true
    }

    fun buttonGoToPersonalCare() {
        _buttonPersonalCareClicked.value = true
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