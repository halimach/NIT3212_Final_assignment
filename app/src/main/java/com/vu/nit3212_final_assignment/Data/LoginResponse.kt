package com.vu.nit3212_final_assignment.Data
import com.squareup.moshi.Json
//Data class representing the response received after a login attempt.
// This class is used to encapsulate the data returned from the server upon successful authentication.
// keypass: A unique key or token issued by the server after successful login.

data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)