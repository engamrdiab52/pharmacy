package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.HomeScreenItem

interface IDownloadHomeScreenItems {
    suspend fun downloadHomeScreenItems(): List<HomeScreenItem>
}