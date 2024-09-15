package com.vu.nit3212_final_assignment.Data

import com.squareup.moshi.Json

data class Dashboard_Output(
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)