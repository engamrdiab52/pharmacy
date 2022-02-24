package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine
import com.amrabdelhamiddiab.core.domain.FavoriteMedicine

interface IUploadFavoriteItem {
    suspend fun uploadFavoriteItem(userId: String, favoriteMedicine: FavoriteMedicine):Boolean
}