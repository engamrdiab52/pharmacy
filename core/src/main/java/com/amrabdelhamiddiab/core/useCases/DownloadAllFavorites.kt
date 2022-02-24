package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadAllFavorites

class DownloadAllFavorites(private val repositoryDownloadAllFavorites: RepositoryDownloadAllFavorites) {
    suspend operator fun invoke() = repositoryDownloadAllFavorites.downloadAllFavorites()
}