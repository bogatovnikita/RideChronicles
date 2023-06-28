package com.bogatovnikita.ridechronicles.ui.details_screen

import com.bogatovnikita.ridechronicles.models.CarModel
import com.bogatovnikita.ridechronicles.models.PostModel

data class DetailsCarState(
    val isLoaded: Boolean = false,
    val listPosts: List<PostModel> = emptyList(),
    val someCar: CarModel = CarModel(
        id = 0,
        brandName = "",
        modelName = "",
        year = 0,
        engineVolume = "",
        listUrl = emptyList()
    )
)
