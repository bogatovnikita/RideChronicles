package com.bogatovnikita.ridechronicles.domain

import com.bogatovnikita.ridechronicles.domain.models.Car

interface ListOfCarRepository {
    suspend fun getListOfCar(): List<Car>
}