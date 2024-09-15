package com.vu.nit3212_final_assignment.dependency

import com.vu.nit3212_final_assignment.Network.ApiService
import com.vu.nit3212_final_assignment.Network.RetrofitInstance

object Network {
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }
}