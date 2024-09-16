package com.vu.nit3212_final_assignment.repository

import com.vu.nit3212_final_assignment.network.ApiService
import com.vu.nit3212_final_assignment.data.Login
//A repository class responsible for handling login operations.
// It uses the ApiService interface to perform network requests related to login functionality.

class Login_Api(private val apiService: ApiService) {
//Performs a login operation by sending the username and password to the API.
//This function wraps the network call in a try-catch block to handle any potential exceptions.
//  username : The username entered by the user.
//  password:  The password entered by the user.
//   A Response object containing the login result.
// throws Exception If the network request fails or an error occurs.

    suspend fun login(username: String, password: String) =
        try {
            // Calls the login endpoint with the provided username and password
            apiService.login(Login(username, password))
        } catch (e: Exception) {
            // Throws an exception with a descriptive error message if the login fails
            throw Exception("Login failed due to an error: ${e.message}")
        }
}
