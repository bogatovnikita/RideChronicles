package com.bogatovnikita.ridechronicles.ui.main_screen

import com.bogatovnikita.ridechronicles.models.CarForListModel

data class CarListState(
    val isLoaded: Boolean = false,
    val listCars: List<CarForListModel> = emptyList(),
    val page: Int = 1
)