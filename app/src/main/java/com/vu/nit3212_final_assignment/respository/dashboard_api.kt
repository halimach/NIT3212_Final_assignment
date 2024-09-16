package com.vu.nit3212_final_assignment.repository

import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.network.RetrofitInstance
//A singleton object responsible for interacting with the API to fetch dashboard data.
// It uses the ApiService interface to make network requests.

object dashboard_api {
//Instance of ApiService, created using RetrofitInstance
    private val apiService: ApiService = RetrofitInstance.apiService
//Fetches dashboard data from the API.
//This function makes a network request to retrieve dashboard data based on the provided keypass.
// keypass:The keypass used to fetch the dashboard data.
// A Response object containing the dashboard data.
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}
