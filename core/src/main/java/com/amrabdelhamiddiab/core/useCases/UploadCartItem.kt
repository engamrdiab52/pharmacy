package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryUploadCartItem
import com.amrabdelhamiddiab.core.domain.CartMedicine

class UploadCartItem(private val repositoryUploadCartItem: RepositoryUploadCartItem) {
    suspend operator fun invoke(userId: String, cartMedicine: CartMedicine) =
        repositoryUploadCartItem.uploadCartItem(userId, cartMedicine)
}