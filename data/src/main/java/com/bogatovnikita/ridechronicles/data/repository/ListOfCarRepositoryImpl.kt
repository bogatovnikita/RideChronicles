package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarRepository

class ListOfCarRepositoryImpl: ListOfCarRepository {
    override suspend fun getListOfCar(): List<Car> {
        TODO("Not yet implemented")
    }
}