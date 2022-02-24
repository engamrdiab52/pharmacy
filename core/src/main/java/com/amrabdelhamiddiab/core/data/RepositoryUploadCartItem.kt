package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine

class RepositoryUploadCartItem(private val iUploadCartItem: IUploadCartItem) {
    suspend fun uploadCartItem(userId: String, cartMedicine: CartMedicine) =
        iUploadCartItem.uploadCartItem(userId, cartMedicine)
}