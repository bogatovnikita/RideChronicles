package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.repository.SomeCarRepository

class SomeCarRepositoryImpl: SomeCarRepository {
    override suspend fun getSomeCar(id: Long): Car {
        TODO("Not yet implemented")
    }
}