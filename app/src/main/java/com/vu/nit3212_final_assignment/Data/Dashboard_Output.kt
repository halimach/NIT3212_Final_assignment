package com.vu.nit3212_final_assignment.data


import com.squareup.moshi.Json
import com.vu.nit3212_final_assignment.data.Entity
//Data class representing the output of a dashboard API response.
data class Dashboard_Output(
//    List of entities returned by the API.Each
//    Entity is represented by an [Entity] object & entityTotal is the total number of entities in the API response
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)