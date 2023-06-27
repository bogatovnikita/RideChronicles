package com.bogatovnikita.ridechronicles.domain.repository

import com.bogatovnikita.ridechronicles.domain.models.CarForList

interface ListOfCarRepository {
    suspend fun getListOfCar(page: Int): List<CarForList>
}