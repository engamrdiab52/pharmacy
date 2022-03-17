package com.amrabdelhamiddiab.pharmacy_1.presentation.medicines

import android.util.Log
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.core.domain.Medicine
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.pharmacy_1.emptyCard
import com.amrabdelhamiddiab.pharmacy_1.medicineCell
import com.amrabdelhamiddiab.pharmacy_1.presentation.home.HomeViewModel

class MedicinesEpoxyController(private val medicinesViewModel: HomeViewModel) :
    TypedEpoxyController<List<Medicine>?>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<Medicine>?) {
        if (!data.isNullOrEmpty()) {
            data.forEachIndexed { _, medicine ->
                medicineCell {
                    Log.d(TAG, "323232322323232$data")
                    id(medicine.id_medicine)
                    medicine(medicine)
                    onClickContent { _ ->
                    }
                }
            }
        } else {
            emptyCard {
                id("EMPTY")
            }
        }
        /* medicineCell {

         }*/
    }
}