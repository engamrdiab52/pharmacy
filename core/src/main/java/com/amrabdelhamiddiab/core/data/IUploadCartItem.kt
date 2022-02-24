package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine

interface IUploadCartItem {
    suspend fun uploadCartItem(userId: String, cartMedicine: CartMedicine): Boolean
}