package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Offer

interface IDownloadOffers {
    suspend fun downloadOffers():List<Offer>?
}