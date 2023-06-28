package com.bogatovnikita.ridechronicles.domain.usecase

import com.bogatovnikita.ridechronicles.domain.models.CarForList
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarsRepository
import javax.inject.Inject

class GetListOfCar @Inject constructor(
    private val listOfCarsRepository: ListOfCarsRepository
) {
    suspend fun getListOfCar(page:Int): List<CarForList> = listOfCarsRepository.getListOfCar(page)
}