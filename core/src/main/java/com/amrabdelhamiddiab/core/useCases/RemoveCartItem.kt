package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryRemoveCartItem
import com.amrabdelhamiddiab.core.domain.CartMedicine

class RemoveCartItem(private val repositoryRemoveCartItem: RepositoryRemoveCartItem) {
    suspend operator fun invoke(userId: String, cartMedicine: CartMedicine) =
        repositoryRemoveCartItem.removeCartItem(userId, cartMedicine)
}