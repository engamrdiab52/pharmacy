package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

class RepositoryUploadFavoriteItem(private val iUploadFavoriteItem: IUploadFavoriteItem) {
    suspend fun uploadFavoriteItem(userId: String, favoriteMedicine: FavoriteMedicine) = iUploadFavoriteItem.uploadFavoriteItem(userId, favoriteMedicine)
}