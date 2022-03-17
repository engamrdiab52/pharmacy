package com.amrabdelhamiddiab.pharmacy_1.presentation.home

import android.graphics.Color
import android.util.Log
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.amrabdelhamiddiab.core.domain.*
import com.amrabdelhamiddiab.core.domain.dataSources.NameOfImages
import com.amrabdelhamiddiab.pharmacy_1.*
import com.amrabdelhamiddiab.pharmacy_1.presentation.activity.MainActivity.Companion.TAG
import com.worldsnas.slider.slider

class HomeEpoxyController(private val homeViewModel: HomeViewModel) : TypedEpoxyController<List<HomeScreenItem>?>(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {
    override fun buildModels(homeScreenItems: List<HomeScreenItem>?) {
        searchBar {
            id("search_bar")
        }
        //*************************************************
        slider {
            val sliderList = homeScreenItems?.filter { it.medicine_image_url.startsWith("slider images/") }
           Log.d(TAG, "sslslslslslsl0$homeScreenItems")
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
                    id(image.id_medicine)
                    image(image)
                }
            }?.let {
                models(
                    it
                )
            }
            //make fliker
            infinite(true)
            copier { oldModel ->
                oldModel as CarocellBindingModel_
                CarocellBindingModel_().apply {
                    id(oldModel.id())
                    image(oldModel.image())
                }
            }
        }
        categoriesTitle {
            id("categories_title")
        }
        categories {
            id("categories_cell")
            url(NameOfImages())
            onClickMedicine{ _ ->
                this@HomeEpoxyController.homeViewModel.putCategoryName("MEDICINE")
                this@HomeEpoxyController.homeViewModel.buttonGoToMedicines()

            }
            onClickHealth { _ ->
                this@HomeEpoxyController.homeViewModel.buttonGoToHealth()
                this@HomeEpoxyController.homeViewModel.putCategoryName("HEALTH")
            }
            onClickAccessories{_ ->
                this@HomeEpoxyController.homeViewModel.buttonGoToAccessories()
                this@HomeEpoxyController.homeViewModel.putCategoryName("ACCESSORIES")
            }
            onClickPersonalCare { _ ->
                this@HomeEpoxyController.homeViewModel.buttonGoToPersonalCare()
                this@HomeEpoxyController.homeViewModel.putCategoryName("PERSONAL CARE")
            }
            onClickBeautyCare { _ ->
                this@HomeEpoxyController.homeViewModel.buttonGoToBeautyCare()
                this@HomeEpoxyController.homeViewModel.putCategoryName("BEAUTY CARE")
            }
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
        val offersList = homeScreenItems?.filter { it.medicine_image_url.startsWith("Offers/") }

        val listOfOffers = offersList?.mapIndexed { _, offer ->
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