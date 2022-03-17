package com.amrabdelhamiddiab.pharmacy_1.presentation.Items

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.domain.Medicine
import com.amrabdelhamiddiab.pharmacy_1.emptyCard
import com.amrabdelhamiddiab.pharmacy_1.medicineCell
import com.amrabdelhamiddiab.pharmacy_1.presentation.home.HomeViewModel

class ItemsEpoxyController(private val medicinesViewModel: HomeViewModel) :
    TypedEpoxyController<List<Medicine>?>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<Medicine>?) {
        if (!data.isNullOrEmpty()) {
            data.forEachIndexed { _, medicine ->
                medicineCell {
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