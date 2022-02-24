package com.amrabdelhamiddiab.core.data

class RepositoryDownloadAllMedicines(private val iDownloadAllMedicines: IDownloadAllMedicines) {
    suspend fun downloadAllMedicines() = iDownloadAllMedicines.downloadAllMedicines()
}