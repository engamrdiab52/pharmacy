package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Medicine

interface IDownloadOneCategoryMedicines {
    suspend fun downloadOneCategoryMedicines(categoryName:String): List<Medicine>?
}