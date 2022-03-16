package com.amrabdelhamiddiab.core.domain

data class HomeScreenItem(
    val code_medicine: Long = 0L,
    var id_medicine: String = "",
    val medicine_image_url: String = "",
    val name_ar_Medicine: String = "",
    val name_en_Medicine: String = "",
    val offer_on_medicine: String = "",
    val price_medicine: String = ""
)