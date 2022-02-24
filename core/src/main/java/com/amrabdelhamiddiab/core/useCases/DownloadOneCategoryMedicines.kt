package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadOneCategoryMedicines

class DownloadOneCategoryMedicines(private val repositoryDownloadOneCategoryMedicines: RepositoryDownloadOneCategoryMedicines) {
    suspend operator fun invoke(categoryName:String) = repositoryDownloadOneCategoryMedicines.downloadOneCategoryMedicines(categoryName)
}