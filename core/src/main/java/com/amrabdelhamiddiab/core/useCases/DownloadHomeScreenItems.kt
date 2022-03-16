package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadHomeScreenItems

class DownloadHomeScreenItems(private val repositoryDownloadHomeScreenItems: RepositoryDownloadHomeScreenItems) {
    suspend operator fun invoke() = repositoryDownloadHomeScreenItems.downloadHomeScreenItems()
}