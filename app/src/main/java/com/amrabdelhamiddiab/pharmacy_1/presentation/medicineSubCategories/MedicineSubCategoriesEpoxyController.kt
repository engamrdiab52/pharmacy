package com.amrabdelhamiddiab.pharmacy_1.presentation.medicineSubCategories

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.domain.dataSources.SubCategoriesIcons
import com.amrabdelhamiddiab.pharmacy_1.emptyCard
import com.amrabdelhamiddiab.pharmacy_1.medicineSubCategories
import com.amrabdelhamiddiab.pharmacy_1.presentation.medicines.MedicinesViewModel

class MedicineSubCategoriesEpoxyController(private val medicinesViewModel: MedicinesViewModel) :
    TypedEpoxyController<List<SubCategoriesIcons>?>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<SubCategoriesIcons>?) {
        if (!data.isNullOrEmpty()) {
            data.forEachIndexed { _, subCategory ->
                medicineSubCategories {
                    id(subCategory.nameOfSubCategory)
                    subCategoriesIcon(subCategory)
                    onClickContent { _ ->
                        this@MedicineSubCategoriesEpoxyController.medicinesViewModel.setUrlOfSubCategory(
                            subCategory.nameOfSubCategory
                        )
                        this@MedicineSubCategoriesEpoxyController.medicinesViewModel.subCategoryIconClick()

                    }
                }
                /*    {
                       Log.d(MainActivity.TAG, "323232322323232$data")
                       id(medicine.id_medicine)
                       medicine(medicine)
                       onClickContent { _ ->

                       }
                   }*/
            }
        } else {
            emptyCard {
                id("EMPTY")
            }
        }
    }
}