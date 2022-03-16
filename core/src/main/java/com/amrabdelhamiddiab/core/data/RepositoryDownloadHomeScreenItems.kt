package com.amrabdelhamiddiab.core.data

class RepositoryDownloadHomeScreenItems(private val iDownloadHomeScreenItems: IDownloadHomeScreenItems) {
suspend fun downloadHomeScreenItems() = iDownloadHomeScreenItems.downloadHomeScreenItems()
}