package com.amrabdelhamiddiab.core.data

class RepositoryDownloadAllFavorites(private val iDownloadAllFavorites: IDownloadAllFavorites) {
    suspend fun downloadAllFavorites() = iDownloadAllFavorites.downloadAllFavorites()
}