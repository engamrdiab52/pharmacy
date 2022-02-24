package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.RepositoryResetUserPassword

class ResetUserPassword(private val repositoryResetUserPassword: RepositoryResetUserPassword) {
    suspend operator fun invoke(email: String) =
        repositoryResetUserPassword.resetUserPassword(email)
}