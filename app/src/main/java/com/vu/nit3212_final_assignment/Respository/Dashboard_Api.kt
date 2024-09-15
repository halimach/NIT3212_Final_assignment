package com.vu.nit3212_final_assignment.Respositoryimport
import javax.inject.Inject

class Dashboard_Api @Inject constructor(
    private val apiService: ApiService)
{
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}