package com.amrabdelhamiddiab.core.data

class RepositoryDownloadOffers(private val iDownloadOffers: IDownloadOffers) {
    suspend fun downloadOffers() = iDownloadOffers.downloadOffers()
}