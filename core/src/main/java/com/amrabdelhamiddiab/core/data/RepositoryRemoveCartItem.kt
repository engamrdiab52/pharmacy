package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine

class RepositoryRemoveCartItem(private val iRemoveCartItem: IRemoveCartItem) {
    suspend fun removeCartItem(userId: String, cartMedicine: CartMedicine) =
        iRemoveCartItem.removeCartItem(userId, cartMedicine)
}