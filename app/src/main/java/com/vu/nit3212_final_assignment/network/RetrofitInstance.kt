package com.vu.nit3212_final_assignment.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//A singleton object that provides a Retrofit instance for network operations.
// It is responsible for creating and configuring the Retrofit instance used to make HTTP requests.

object RetrofitInstance {
// Base URL of the API
    private const val BASE_URL = "https://vu-nit3213-api.onrender.com/"
// Logging interceptor for monitoring network requests and responses.
// The logging level is set to BODY, which logs request and response lines and their respective headers and bodies.

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
//OkHttpClient with the logging interceptor added.
// This client is responsible for managing network requests, adding interceptors, and handling responses.

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
//Moshi instance for converting JSON to Kotlin objects and vice versa.
//The KotlinJsonAdapterFactory is added to handle Kotlin-specific features.

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

//Retrofit instance configured with the base URL, Moshi converter, and OkHttpClient.
// This instance is used to generate API service implementations.

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

// An instance of the API service interface that defines the endpoints and request methods.

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}