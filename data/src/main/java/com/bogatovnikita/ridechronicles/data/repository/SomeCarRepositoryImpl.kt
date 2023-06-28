package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.data.retrofit.ApiService
import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.repository.SomeCarRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class SomeCarRepositoryImpl
@Inject constructor(private val apiService: ApiService) : SomeCarRepository {

    override suspend fun getSomeCar(id: Long): Car {
        val response = apiService.getCar(id).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            val localCar = response.body()!!.car
            Car(
                id = localCar.id,
                brandName = localCar.brandName,
                modelName = localCar.modelName,
                year = localCar.year,
                engineVolume = localCar.engineVolume,
                listUrl = localCar.images.map { it.url })
        } else {
            return Car(
                id = 0,
                brandName = "",
                modelName = "",
                year = 0,
                engineVolume = "",
                listUrl = emptyList()
            )
        }
    }
}