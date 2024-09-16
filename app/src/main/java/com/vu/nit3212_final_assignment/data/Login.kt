package com.vu.nit3212_final_assignment.data

import com.squareup.moshi.Json
//Data class representing a login request.
// This class is used to encapsulate the user's credentials for authentication.
// username: The username of the user attempting to log in.
// password :The password of the user attempting to log in.
data class Login(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)