package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.data.retrofit.ApiService
import com.bogatovnikita.ridechronicles.data.retrofit.models.TransmissionName
import com.bogatovnikita.ridechronicles.domain.models.CarForList
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class ListOfCarRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ListOfCarRepository {

    override suspend fun getListOfCar(page: Int): List<CarForList> {
        val response = apiService.getListCars(page).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            response.body()!!.map {
                CarForList(
                    idCar = it.id,
                    brandName = it.brandName,
                    modelName = it.modelName,
                    engineName = it.engineName,
                    year = it.year,
                    transmissionName = if (it.transmissionName == TransmissionName.At) "AT" else "MT",
                    urlPhoto = it.image
                )
            }
        } else {
            emptyList()
        }
    }
}