package com.vu.nit3212_final_assignment.Data

import com.squareup.moshi.Json

data class Login(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)