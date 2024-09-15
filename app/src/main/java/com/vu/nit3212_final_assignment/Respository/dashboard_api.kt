package com.vu.nit3212_final_assignment.Respositoryimport

import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.network.RetrofitInstance

object dashboard_api {
    private val apiService: ApiService = RetrofitInstance.apiService

    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}
