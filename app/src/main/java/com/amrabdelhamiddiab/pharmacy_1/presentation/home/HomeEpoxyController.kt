package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.graphics.Color
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.pharmacy_1.CarocellBindingModel_
import com.worldsnas.slider.slider

class HomeEpoxyController: TypedEpoxyController<List<String>>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(data: List<String>?) {
        slider {
            id("dot_indicator")
            //delay before every cycle if user is not scrolling
            cycleDelay(3_000)
            //controll the indicator visibility
            indicatorVisible(true)
            //Front/Selected indicator dot color (if indicator visible)
            indicatorSelectedDotColor(Color.BLACK)
            //rest of indicator dot color (if indicator visible)
            indicatorDotColor(Color.GRAY)
            //this is a extension function not the constructor
            data?.map{
                CarocellBindingModel_().apply {
                    id("t")
                }
            }?.let {
                models(
                    it
                )
            }
        }
    }
}