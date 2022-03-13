package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadOffers

class DownloadOffers(private val repositoryDownloadOffers: RepositoryDownloadOffers) {
    suspend operator fun invoke()= repositoryDownloadOffers.downloadOffers()
}