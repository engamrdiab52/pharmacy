package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.IDownloadOffers
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await

class DownloadOffersImpl(private val databaseReference: DatabaseReference): IDownloadOffers {
    private val _listOfOffers: MutableList<Offer> = mutableListOf()
    private val listOfOffers: List<Offer> = _listOfOffers

    override suspend fun downloadOffers(): List<Offer>? {
        return try {
            _listOfOffers.clear()
            val snapshot = databaseReference.child("offers").get().await()
            snapshot.children.forEach {
                val item = it.getValue(Offer::class.java)
                item?.let { it1 -> _listOfOffers.add(it1) }
            }
            Log.d(TAG, "999999999999$listOfOffers")
            listOfOffers
        } catch (e: Exception) {
            Log.d(TAG, "999999999999$e")
            emptyList()

        }
    }

}