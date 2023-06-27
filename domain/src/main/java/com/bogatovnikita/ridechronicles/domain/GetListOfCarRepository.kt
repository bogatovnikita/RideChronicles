package com.bogatovnikita.ridechronicles.domain

import com.bogatovnikita.ridechronicles.domain.models.Car
import javax.inject.Inject

class GetListOfCarRepository @Inject constructor(
    private val listOfCarRepository: ListOfCarRepository
) {
    suspend fun getListOfCar(): List<Car> = listOfCarRepository.getListOfCar()
}