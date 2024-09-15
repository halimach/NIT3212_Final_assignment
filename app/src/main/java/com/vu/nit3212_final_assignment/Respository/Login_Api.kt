package com.vu.nit3212_final_assignment.Respository

import com.example.assessment2.data.LoginRequest
import com.example.assessment2.network.ApiService
import javax.inject.Inject

class Login_Api  @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun login(username: String, password: String) =
        try {

            apiService.login(LoginRequest(username, password))
        } catch (e: Exception) {

            throw Exception("Login failed due to an error: ${e.message}")
        }
}