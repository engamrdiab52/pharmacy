package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Categories

interface IDownloadCategories {
    suspend fun downloadCategories():List<Categories>
}