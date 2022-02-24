package com.amrabdelhamiddiab.core.data

class RepositoryDownloadOneMedicine(private val iDownloadOneMedicine: IDownloadOneMedicine) {
    suspend fun downloadOneMedicine(name: String) = iDownloadOneMedicine.downloadOneMedicines(name)
}