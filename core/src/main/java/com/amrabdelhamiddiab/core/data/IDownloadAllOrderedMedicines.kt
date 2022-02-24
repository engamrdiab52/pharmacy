package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.CartMedicine

interface IDownloadAllOrderedMedicines {
    suspend fun downloadAllOrderedMedicines(): List<CartMedicine>?
}