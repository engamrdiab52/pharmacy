package com.amrabdelhamiddiab.core.domain

data class FavoriteMedicine(
    val id_medicine: String,
    val code_medicine: Long,
    val name_en_Medicine:String,
    val name_ar_Medicine: String?,
    val img_url_medicine: String?,
    val price_medicine: Float

)