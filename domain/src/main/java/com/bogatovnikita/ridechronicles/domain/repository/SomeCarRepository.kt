package com.bogatovnikita.ridechronicles.domain.repository

import com.bogatovnikita.ridechronicles.domain.models.Car

interface SomeCarRepository {
    suspend fun getSomeCar(id: Long): Car?
}