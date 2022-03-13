package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.graphics.Color
import android.media.Image
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.pharmacy_1.*
import com.worldsnas.slider.slider

class HomeEpoxyController : TypedEpoxyController<List<ImageOfSlider>?>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(imagesOfSlider: List<ImageOfSlider>?) {
        searchBar {
            id("search_bar")
        }
        //*************************************************
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
            copier { oldModel ->
                oldModel as CarocellBindingModel_
                CarocellBindingModel_().apply {
                    id(oldModel.id())
                    image(oldModel.image())
                }
            }
        }
        //**********************************************************
        offersTitle {
            id("offers_title")
        }
        //*************************************************************
        val offerCaroCellItem = imagesOfSlider?.mapIndexed { _, image ->
            OfferCellBindingModel_().id(image.id)
        }
        carousel {
            id("offers_caroCell")
            offerCaroCellItem?.let { models(it) }

        }
        //***********************************************
        val offerCaroCellItem2 = imagesOfSlider?.mapIndexed { _, image ->
            OfferCellBindingModel_().id(image.id)
        }
        carousel {
            id("offers_caroCell")
            offerCaroCellItem2?.let { models(it) }

        }
        //******************************************
        /*offerCell {
            imagesOfSlider?.mapIndexed { _, image ->
                id(image.id)
            }
        }*/
    }
}