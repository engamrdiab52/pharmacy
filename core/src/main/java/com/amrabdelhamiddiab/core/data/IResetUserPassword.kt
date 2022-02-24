package com.amrabdelhamiddiab.core.data

interface IResetUserPassword {
    suspend fun resetPassword(email: String):Boolean
}