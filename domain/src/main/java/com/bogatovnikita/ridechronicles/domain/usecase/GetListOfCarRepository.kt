package com.bogatovnikita.ridechronicles.domain.usecase

import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarRepository
import javax.inject.Inject

class GetListOfCarRepository @Inject constructor(
    private val listOfCarRepository: ListOfCarRepository
) {
    suspend fun getListOfCar(): List<Car> = listOfCarRepository.getListOfCar()
}