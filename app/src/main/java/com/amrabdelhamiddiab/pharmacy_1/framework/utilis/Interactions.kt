package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import com.amrabdelhamiddiab.core.useCases.*

data class Interactions(
    val resetUserPassword: ResetUserPassword,
    val sendEmailVerification: SendEmailVerification,
    val signUpUser: SignUpUser,
    val signOutUser: SignOutUser,
    val verifyUserEmail: VerifyUserEmail,
    val signInUser: SignInUser,
    val emailVerifiedState: EmailVerifiedState,
    val downloadCategories: DownloadCategories,
    val uploadFavoriteItem: UploadFavoriteItem,
    val removeFavoriteItem: RemoveFavoriteItem,
)