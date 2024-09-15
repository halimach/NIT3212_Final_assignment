package com.vu.nit3212_final_assignment.repository

import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.data.Login

class Login_Api(private val apiService: ApiService) {

    suspend fun login(username: String, password: String) =
        try {
            apiService.login(Login(username, password))
        } catch (e: Exception) {
            throw Exception("Login failed due to an error: ${e.message}")
        }
}
