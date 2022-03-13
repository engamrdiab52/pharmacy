package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Categories
import com.amrabdelhamiddiab.core.domain.ImageOfSlider

interface IDownloadImagesOfSlider {
    suspend fun downloadImagesOfSlider():List<ImageOfSlider>?
}