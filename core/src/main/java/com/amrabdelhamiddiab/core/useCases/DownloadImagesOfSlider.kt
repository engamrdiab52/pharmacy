package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadImagesOfSlider

class DownloadImagesOfSlider(private val repositoryDownloadImagesOfSlider: RepositoryDownloadImagesOfSlider) {
    suspend operator fun invoke() = repositoryDownloadImagesOfSlider.downloadImagesOfSlider()
}