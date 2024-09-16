package com.vu.nit3212_final_assignment.dependency


import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.network.RetrofitInstance
//Object responsible for providing network-related dependencies.
//This object contains methods to supply instances of network services.
object Network {
// This method fetches the singleton instance of the API service from [RetrofitInstance].
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }
}