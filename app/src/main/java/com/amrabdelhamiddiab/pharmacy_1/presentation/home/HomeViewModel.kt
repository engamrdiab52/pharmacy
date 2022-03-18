package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.core.domain.Medicine
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.Interactions
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

    fun downloadHomeScreenItems() {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfHomeScreenItems.postValue(dependencies.downloadHomeScreenItems())
            _downloading.postValue(false)
        }
    }

    private val _listOfMedicines = SingleLiveEvent<List<Medicine>?>()
    val listOfMedicines: LiveData<List<Medicine>?> get() = _listOfMedicines

    private val _urlSubCategory = SingleLiveEvent<String>()
    val urlSubCategory: LiveData<String> get() = _urlSubCategory

    private val _mainCategory = SingleLiveEvent<String>()
    val mainCategory: LiveData<String> get() = _mainCategory

    private val _subCategoryIconClicked = SingleLiveEvent<Boolean>()
    val subCategoryIconClicked: LiveData<Boolean> get() = _subCategoryIconClicked

    fun putCategoryName(name: String) {
        _mainCategory.value = name
    }

    fun subCategoryIconClick() {
        _subCategoryIconClicked.value = true
    }

    fun putUrlOfSubCategory(url: String) {
        _urlSubCategory.value = url
    }

    fun downloadMedicines(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfMedicines.postValue(dependencies.downloadAllMedicines(url))
            _downloading.postValue(false)
            Log.d(TAG, "qqqqqqqqqqqq" + listOfMedicines.value.toString())
        }
    }

}