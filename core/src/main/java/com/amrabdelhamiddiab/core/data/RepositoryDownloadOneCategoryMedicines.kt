package com.amrabdelhamiddiab.core.data

class RepositoryDownloadOneCategoryMedicines(private val iDownloadOneCategoryMedicines: IDownloadOneCategoryMedicines) {
    suspend fun downloadOneCategoryMedicines(categoryName:String) = iDownloadOneCategoryMedicines.downloadOneCategoryMedicines(categoryName)
}