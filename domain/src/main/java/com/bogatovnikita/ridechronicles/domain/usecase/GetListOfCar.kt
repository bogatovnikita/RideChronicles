package com.bogatovnikita.ridechronicles.domain.usecase

import com.bogatovnikita.ridechronicles.domain.models.CarForList
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarRepository
import javax.inject.Inject

class GetListOfCar @Inject constructor(
    private val listOfCarRepository: ListOfCarRepository
) {
    suspend fun getListOfCar(page:Int): List<CarForList> = listOfCarRepository.getListOfCar(page)
}