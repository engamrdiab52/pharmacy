package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadAllMedicines

class DownloadAllMedicines(private val repositoryDownloadAllMedicines: RepositoryDownloadAllMedicines) {
    suspend operator fun invoke(url: String) = repositoryDownloadAllMedicines.downloadAllMedicines(url)
}