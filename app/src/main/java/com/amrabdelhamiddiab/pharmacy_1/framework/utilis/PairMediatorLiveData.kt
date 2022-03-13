package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class PairMediatorLiveData<F, S>(firstLiveData: LiveData<F>, secondLiveData: LiveData<S>) : MediatorLiveData<Pair<F?, S?>>() {
    init {
        addSource(firstLiveData) { firstLiveDataValue: F -> value = firstLiveDataValue to secondLiveData.value }
        addSource(secondLiveData) { secondLiveDataValue: S -> value = firstLiveData.value to secondLiveDataValue }
    }
}