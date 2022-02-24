package com.amrabdelhamiddiab.core.data

class RepositoryResetPassword(private val iResetPassword: IResetPassword) {
    suspend fun resetPasswordByFirebase(email: String) =
        iResetPassword.resetPassword(email)
}