package com.bogatovnikita.ridechronicles.domain.models

data class Car(
    val id: Long = 0L,
    val name: String = "",
    val listUrl: List<String> = emptyList(),
)