package com.bogatovnikita.ridechronicles.models

data class CarModel(
    val id: Long = 0L,
    val brandName: String = "",
    val modelName: String = "",
    val year: Long = 0L,
    val engineVolume: String = "",
    val listUrl: List<String> = emptyList(),
)
