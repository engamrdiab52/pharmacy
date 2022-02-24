package com.amrabdelhamiddiab.core.data

class RepositoryDownloadAllOrderedMedicines(private val iDownloadAllOrderedMedicines: IDownloadAllOrderedMedicines) {
    suspend fun downloadAllOrderedMedicines() =
        iDownloadAllOrderedMedicines.downloadAllOrderedMedicines()
}