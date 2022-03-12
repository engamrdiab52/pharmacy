package com.amrabdelhamiddiab.pharmacy_1.framework.utilis

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.amrabdelhamiddiab.pharmacy_1.framework.glide.GlideApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        //Note glide downloads images in background thread
       // GlideApp.with(view.context).load(Firebase.storage.getReferenceFromUrl(url)).into(view)
      GlideApp.with(view.context).load(Firebase.storage.reference.child(url)).into(view)
       // Log.d(TAG, url+"44444444444")

    }

}