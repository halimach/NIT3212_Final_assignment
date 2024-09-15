package com.vu.nit3212_final_assignment.Data
import com.squareup.moshi.Json

data class Login_Output(
    @Json(name = "keypass") val keypass: String
)