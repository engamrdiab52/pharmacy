package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryRemoveFavoriteItem
import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

class RemoveFavoriteItem(private val repositoryRemoveFavoriteItem: RepositoryRemoveFavoriteItem) {
    suspend operator fun invoke(userId: String, favoriteMedicine: FavoriteMedicine) =
        repositoryRemoveFavoriteItem.removeFavoriteItem(userId, favoriteMedicine)
}