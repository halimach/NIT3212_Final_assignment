package com.vu.nit3212_final_assignment.data


import com.squareup.moshi.Json
import com.vu.nit3212_final_assignment.data.Entity

data class Dashboard_Output(
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)