package com.amrabdelhamiddiab.pharmacy_1.presentation.subCategories

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.domain.dataSources.SubCategoriesIcons
import com.amrabdelhamiddiab.pharmacy_1.emptyCard
import com.amrabdelhamiddiab.pharmacy_1.medicineSubCategories
import com.amrabdelhamiddiab.pharmacy_1.presentation.home.HomeViewModel

class subCategoriesEpoxyController(private val medicinesViewModel: HomeViewModel) :
    TypedEpoxyController<List<SubCategoriesIcons>?>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<SubCategoriesIcons>?) {
        if (!data.isNullOrEmpty()) {
            data.forEachIndexed { _, subCategory ->
                medicineSubCategories {
                    id(subCategory.urlOfSubCategory)
                    subCategoriesIcon(subCategory)
                    onClickContent { _ ->
                        this@subCategoriesEpoxyController.medicinesViewModel.putUrlOfSubCategory(
                            subCategory.urlOfSubCategory
                        )
                        this@subCategoriesEpoxyController.medicinesViewModel.subCategoryIconClick()
                    }
                }
            }
        } else {
            emptyCard {
                id("EMPTY")
            }
        }
    }
}