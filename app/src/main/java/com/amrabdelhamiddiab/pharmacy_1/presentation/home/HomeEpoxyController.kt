package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.graphics.Color
import android.media.Image
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.pharmacy_1.CarocellBindingModel_
import com.worldsnas.slider.slider

class HomeEpoxyController : TypedEpoxyController<List<ImageOfSlider>?>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(imagesOfSlider: List<ImageOfSlider>?) {
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
            // it hase to be map function not forEach
            imagesOfSlider?.mapIndexed { _, image ->
                CarocellBindingModel_().apply {
                    id(image.id)
                    image(image)
                }
            }?.let {
                models(
                    it
                )
            }
            infinite(true)
            copier {
                oldModel -> oldModel as CarocellBindingModel_
                CarocellBindingModel_().apply {
                    id(oldModel.id())
                    image(oldModel.image())
                }
            }
        }
    }
}