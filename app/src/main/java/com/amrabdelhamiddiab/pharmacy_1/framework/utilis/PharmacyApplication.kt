package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import android.app.Application
import com.amrabdelhamiddiab.core.data.*
import com.amrabdelhamiddiab.core.useCases.*
import com.amrabdelhamiddiab.pharmacy_1.framework.firebase.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class PharmacyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.database.setPersistenceEnabled(true)
        val databaseReference = Firebase.database.reference
        val mAuth = FirebaseAuth.getInstance()
        PharmacyViewModelFactory.inject(
            this, Interactions(
                ResetUserPassword(
                    RepositoryResetUserPassword(
                        ResetUserPasswordImpl(
                            mAuth,
                            this.applicationContext
                        )
                    )
                ), SendEmailVerification(
                    RepositorySendEmailVerification(
                        SendEmailVerificationImpl(
                            mAuth
                        )
                    )
                ), SignUpUser(RepositorySignUpUser((SignupUserImpl(mAuth)))),
                SignOutUser(RepositorySignOutUser(SignOutUserImpl(mAuth))),
                VerifyUserEmail(RepositoryVerifyEmail(VerifyUserEmailImpl(mAuth))),
                SignInUser(RepositorySignInUser(SignInUserImpl(mAuth))),
                EmailVerifiedState(
                    RepositoryEmailVerifiedState(
                        EmailVerifiedStateImpl(
                            mAuth,
                            this.applicationContext
                        )
                    )
                ),
                DownloadOffers(
                    RepositoryDownloadOffers(
                        DownloadOffersImpl(
                            databaseReference
                        )
                    )
                ),
                DownloadImagesOfSlider(
                    RepositoryDownloadImagesOfSlider(
                        DownloadImagesOfSliderImpl(
                            databaseReference
                        )
                    )
                ),
                DownloadHomeScreenItems(
                    RepositoryDownloadHomeScreenItems(
                        DownloadHomeScreenItemsImpl(
                            databaseReference
                        )
                    )
                ),
                DownloadAllMedicines(
                    RepositoryDownloadAllMedicines(
                        DownloadAllMedicinesImpl(
                            databaseReference
                        )
                    )
                )
            )
        )
    }
}