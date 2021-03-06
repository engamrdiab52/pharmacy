package com.amrabdelhamiddiab.core.domain

data class Medicine(
    var id_medicine: String,
    val code_medicine: Long,
    val name_en_Medicine:String,
    val name_ar_Medicine: String?,
    val name_clinical_medicine: String,
    val category_en_medicine: String,
    val category_ar_medicine: String?,
    val img_url_medicine: String?,
    val description_ar_url_medicine: String,
    val company_name_medicine: String,
    val price_medicine: Float,
    val availability_medicine: Boolean,
    val offer_on_medicine: Long?,
    val alternatives_url_medicine: String?)

