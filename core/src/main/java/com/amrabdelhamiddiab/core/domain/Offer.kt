package com.amrabdelhamiddiab.core.domain

data class Offer(
    var id_medicine: String,
    val code_medicine: Long,
    val name_en_Medicine:String,
    val name_ar_Medicine: String,
    val price_medicine: String,
    val offer_on_medicine: String,
)
/*val img_url_medicine: String?,*/
/* val description_ar_url_medicine: String,*/