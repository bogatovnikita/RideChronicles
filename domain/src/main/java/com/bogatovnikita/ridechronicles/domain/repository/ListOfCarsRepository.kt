package com.bogatovnikita.ridechronicles.domain.repository

import com.bogatovnikita.ridechronicles.domain.models.CarForList

interface ListOfCarsRepository {
    suspend fun getListOfCar(page: Int): List<CarForList>
}