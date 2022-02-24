package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryUploadFavoriteItem
import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

class UploadFavoriteItem(private val repositoryUploadFavoriteItem: RepositoryUploadFavoriteItem) {
    suspend operator fun invoke(userId: String, favoriteMedicine: FavoriteMedicine) =
        repositoryUploadFavoriteItem.uploadFavoriteItem(userId, favoriteMedicine)
}