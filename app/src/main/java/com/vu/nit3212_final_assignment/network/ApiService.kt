package com.vu.nit3212_final_assignment.network

import com.vu.nit3212_final_assignment.data.LoginResponse
import com.vu.nit3212_final_assignment.data.Login
import com.vu.nit3212_final_assignment.data.Dashboard_Output
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//Defines the API endpoints for network communication.
//This interface outlines the HTTP methods and endpoints used for interacting with the server.

interface ApiService {
//Makes a POST request to the authentication endpoint to log in.
// Sends a [Login] object in the request body and expects a [LoginResponse] in return.
//
// login A : [Login] object containing the username and password.
//  A [Response] wrapping a [LoginResponse] which contains the keypass on successful login.

    @POST("/ort/auth")
    suspend fun login(@Body login: Login): Response<LoginResponse>
//Makes a GET request to fetch dashboard data.
//  Uses a path parameter to specify the keypass and expects a [Dashboard_Output] in return.
// keypass: A string representing the keypass for authentication.
// A [Response] wrapping a [Dashboard_Output] which contains entities and entity total.

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<Dashboard_Output>
}
