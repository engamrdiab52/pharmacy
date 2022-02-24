package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

interface IDownloadAllFavorites {
    suspend fun downloadAllFavorites():List<FavoriteMedicine>?
}