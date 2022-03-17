package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.IDownloadAllMedicines
import com.amrabdelhamiddiab.core.domain.Medicine
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await

class DownloadAllMedicinesImpl(private val databaseReference: DatabaseReference): IDownloadAllMedicines {
    private val _listOfMedicines: MutableList<Medicine> = mutableListOf()
    private val listOfMedicines: List<Medicine> = _listOfMedicines
    override suspend fun downloadAllMedicines(url: String): List<Medicine>? {
        return try {
            _listOfMedicines.clear()
            val snapshot = databaseReference.child(url).get().await()
            snapshot.children.forEach {
                val item = it.getValue(Medicine::class.java)
                item?.let { it1 -> _listOfMedicines.add(it1) }
            }
            Log.d(MainActivity.TAG, "999999999999$listOfMedicines")
            listOfMedicines
        } catch (e: Exception) {
            Log.d(MainActivity.TAG, "999999999999$e")
            emptyList()

        }
    }
}