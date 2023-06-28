package com.bogatovnikita.ridechronicles.domain.usecase

import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.repository.SomeCarRepository
import javax.inject.Inject

class GetSomeCar @Inject constructor(private val someCarRepository: SomeCarRepository) {
    suspend fun getCar(id: Long): Car = someCarRepository.getSomeCar(id)
}