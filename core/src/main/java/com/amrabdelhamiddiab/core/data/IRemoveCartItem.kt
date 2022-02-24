package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine

interface IRemoveCartItem {
    suspend fun removeCartItem(userId: String, cartMedicine: CartMedicine):Boolean
}