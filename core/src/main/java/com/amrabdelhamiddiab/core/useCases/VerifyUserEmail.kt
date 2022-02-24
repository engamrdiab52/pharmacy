package com.amrabdelhamiddiab.core.useCases

import com.amrabdelhamiddiab.core.data.IVerifyUserEmail

class VerifyUserEmail(private val iVerifyUserEmail: IVerifyUserEmail) {
    suspend operator fun invoke() = iVerifyUserEmail.verifyUserEmail()
}