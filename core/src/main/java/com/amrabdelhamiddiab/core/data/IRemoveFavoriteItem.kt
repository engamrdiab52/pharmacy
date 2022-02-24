package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine
import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

interface IRemoveFavoriteItem {
    suspend fun removeFavoriteItem(userId: String, favoriteMedicine: FavoriteMedicine):Boolean
}