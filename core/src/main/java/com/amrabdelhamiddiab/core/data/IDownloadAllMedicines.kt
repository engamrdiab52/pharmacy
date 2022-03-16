package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Medicine

interface IDownloadAllMedicines {
    suspend fun downloadAllMedicines(url: String): List<Medicine>?
}