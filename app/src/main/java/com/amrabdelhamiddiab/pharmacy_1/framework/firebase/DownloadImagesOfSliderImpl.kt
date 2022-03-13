package com.amrabdelhamiddiab.pharmacy_1.framework.firebase

import android.util.Log
import com.amrabdelhamiddiab.core.data.IDownloadImagesOfSlider
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.MainActivity
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await

class DownloadImagesOfSliderImpl(private val databaseReference: DatabaseReference):IDownloadImagesOfSlider {
    private val _listOfOfImagesOfSlider: MutableList<ImageOfSlider> = mutableListOf()
    private val listOfOfImagesOfSlider: List<ImageOfSlider> = _listOfOfImagesOfSlider

    override suspend fun downloadImagesOfSlider(): List<ImageOfSlider>? {
        return try {
            _listOfOfImagesOfSlider.clear()
            val snapshot = databaseReference.child("ads_images").get().await()
            snapshot.children.forEach {
                val item = it.getValue(ImageOfSlider::class.java)
                item?.let { it1 -> _listOfOfImagesOfSlider.add(it1) }
            }
            Log.d(MainActivity.TAG, "88888888888$listOfOfImagesOfSlider")
            listOfOfImagesOfSlider
        } catch (e: Exception) {
            Log.d(MainActivity.TAG, "88888888888$e")
            emptyList()

        }
    }
}