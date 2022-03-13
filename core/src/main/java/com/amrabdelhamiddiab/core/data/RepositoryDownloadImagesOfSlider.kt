package com.amrabdelhamiddiab.core.data

class RepositoryDownloadImagesOfSlider(private val iDownloadImagesOfSlider: IDownloadImagesOfSlider) {
    suspend fun downloadImagesOfSlider() = iDownloadImagesOfSlider.downloadImagesOfSlider()
}