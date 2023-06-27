package com.bogatovnikita.ridechronicles.ui.main_screen

import com.bogatovnikita.ridechronicles.models.CarForList

data class ListOfCarsState(
    val isLoaded: Boolean = false,
    val listCars: List<CarForList> = emptyList(),
    val page: Int = 1
)