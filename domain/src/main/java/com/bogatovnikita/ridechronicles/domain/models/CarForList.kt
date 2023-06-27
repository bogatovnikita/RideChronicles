package com.bogatovnikita.ridechronicles.domain.models

data class CarForList(
    val idCar: Long = 0L,
    val brandName: String = "",
    val modelName: String = "",
    val engineName: String = "",
    val year: Long = 0L,
    val transmissionName: String = "",
    val urlPhoto: String = ""
)