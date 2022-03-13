package com.amrabdelhamiddiab.core.domain

data class Offer(
    val code_medicine: Long = 0L,
    var id_medicine: String = "",
    val medicine_image_url:String = "",
    val name_ar_Medicine: String = "",
    val name_en_Medicine:String = "",
    val offer_on_medicine: String = "",
    val price_medicine: String = ""
)
/*val img_url_medicine: String?,*/
/* val description_ar_url_medicine: String,*/