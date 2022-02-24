package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryDownloadOneMedicine

class DownloadOneMedicine(private val repositoryDownloadOneMedicine: RepositoryDownloadOneMedicine) {
    suspend operator fun invoke(name: String) = repositoryDownloadOneMedicine.downloadOneMedicine(name)
}