package com.vu.nit3212_final_assignment.network

import com.vu.nit3212_final_assignment.Data.Login_Output
import com.vu.nit3212_final_assignment.data.Login
import com.vu.nit3212_final_assignment.data.Dashboard_Output
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/ort/auth")
    suspend fun login(@Body login: Login): Response<Login_Output>

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<Dashboard_Output>
}
