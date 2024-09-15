package com.vu.nit3212_final_assignment.Data


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entities(
    @Json(name = "itemOne") val itemOne: String,
    @Json(name = "itemTwo") val itemTwo: String,
    @Json(name = "itemThree") val itemThree: String,
    @Json(name = "itemFour") val itemFour: String,
    @Json(name = "description") val description: String
) : Parcelable