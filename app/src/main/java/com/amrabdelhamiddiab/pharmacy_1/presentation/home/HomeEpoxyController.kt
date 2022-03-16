package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.graphics.Color
import android.media.Image
import android.util.Log
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.Typed2EpoxyController
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.amrabdelhamiddiab.core.domain.ImageOfSlider
import com.amrabdelhamiddiab.core.domain.ListOfImages
import com.amrabdelhamiddiab.core.domain.NameOfImages
import com.amrabdelhamiddiab.core.domain.Offer
import com.amrabdelhamiddiab.pharmacy_1.*
import com.amrabdelhamiddiab.pharmacy_1.MainActivity.Companion.TAG
import com.worldsnas.slider.slider

class HomeEpoxyController(private val homeViewModel: HomeViewModel) : Typed2EpoxyController<List<ImageOfSlider>?, List<Offer>?>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(imagesOfSlider: List<ImageOfSlider>?, offers: List<Offer>?) {
        searchBar {
            id("search_bar")
        }
        //*************************************************
        slider {
            val sliderList = imagesOfSlider?.filter { it.id.startsWith("i") }
            id("dot_indicator")
            //delay before every cycle if user is not scrolling
            cycleDelay(3_000)
            //controll the indicator visibility
            indicatorVisible(false)
            //Front/Selected indicator dot color (if indicator visible)
            indicatorSelectedDotColor(Color.GRAY)
            //rest of indicator dot color (if indicator visible)
            indicatorDotColor(Color.BLUE)
            //this is a extension function not the constructor
            // it hase to be map function not forEach
            sliderList?.mapIndexed { _, image ->
                CarocellBindingModel_().apply {
                    id(image.id)
                    image(image)
                }
            }?.let {
                models(
                    it
                )
            }
            //make fliker
       /*     infinite(false)
            copier { oldModel ->
                oldModel as CarocellBindingModel_
                CarocellBindingModel_().apply {
                    id(oldModel.id())
                    image(oldModel.image())
                }
            }*/
        }
        categoriesTitle {
            id("categories_title")
        }
        categories {
            id("categories_cell")
            url(NameOfImages())
           /* val categoriesList = imagesOfSlider?.filter { it.id.startsWith("cat") }
            val myListObject : ListOfImages = categoriesList?.let { ListOfImages(it) }!!*/
         //   listOfImagesOfCategories(myListObject)
          //  listOfImagesOfCategories(myListObject)
        }
        //**********************************************************
        offersTitle {
            id("offers_title")
        }
        //*************************************************************
        val listOfOffers = offers?.mapIndexed { _, offer ->
            OfferCellBindingModel_().apply {
                id(offer.id_medicine)
                offer(offer)
            }
        }
        carousel {
            id("offers_caroCell")
            listOfOffers?.let { models(it) }
        }
        //***********************************************
/*        val offerCaroCellItem2 = imagesOfSlider?.mapIndexed { _, image ->
            OfferCellBindingModel_().id(image.id)
        }
        carousel {
            id("fers_caroCell")
            offerCaroCellItem2?.let { models(it) }

        }*/
        //******************************************
        /*offerCell {
            imagesOfSlider?.mapIndexed { _, image ->
                id(image.id)
            }
        }*/
    }
}