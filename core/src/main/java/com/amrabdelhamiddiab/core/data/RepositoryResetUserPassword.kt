package com.amrabdelhamiddiab.core.data

class RepositoryResetUserPassword(private val iResetUserPassword: IResetUserPassword) {
    suspend fun resetUserPassword(email: String) =
        iResetUserPassword.resetPassword(email)
}