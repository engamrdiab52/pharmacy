package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadAllOrderedMedicines

class DownloadAllOrderedMedicines(private val repositoryDownloadAllOrderedMedicines: RepositoryDownloadAllOrderedMedicines) {
    suspend operator fun invoke() = repositoryDownloadAllOrderedMedicines.downloadAllOrderedMedicines()
}