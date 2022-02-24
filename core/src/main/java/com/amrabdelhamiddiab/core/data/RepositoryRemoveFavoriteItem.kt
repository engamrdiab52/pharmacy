package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

class RepositoryRemoveFavoriteItem(private val iRemoveFavoriteItem: IRemoveFavoriteItem) {
    suspend fun removeFavoriteItem(userId: String, favoriteMedicine: FavoriteMedicine) =
        iRemoveFavoriteItem.removeFavoriteItem(userId, favoriteMedicine )
}