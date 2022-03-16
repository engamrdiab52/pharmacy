package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.IDownloadHomeScreenItems
import com.amrabdelhamiddiab.core.domain.HomeScreenItem
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.MainActivity
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await

class DownloadHomeScreenItemsImpl(private val databaseReference: DatabaseReference): IDownloadHomeScreenItems {
    private val _listOfHomeScreenItems: MutableList<HomeScreenItem> = mutableListOf()
    private val listOfHomeScreenItems: List<HomeScreenItem> = _listOfHomeScreenItems
    override suspend fun downloadHomeScreenItems(): List<HomeScreenItem> {
        return try {
            _listOfHomeScreenItems.clear()
            val snapshot = databaseReference.child("offers").get().await()
            snapshot.children.forEach {
                val item = it.getValue(HomeScreenItem::class.java)
                item?.let { it1 -> _listOfHomeScreenItems.add(it1) }
            }
            Log.d(MainActivity.TAG, "999999999999$listOfHomeScreenItems")
            listOfHomeScreenItems
        } catch (e: Exception) {
            Log.d(MainActivity.TAG, "999999999999$e")
            emptyList()

        }
    }
}