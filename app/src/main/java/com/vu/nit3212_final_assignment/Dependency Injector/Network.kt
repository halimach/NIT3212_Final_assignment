package com.vu.nit3212_final_assignment.dependency


import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.network.RetrofitInstance

object Network {
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }
}