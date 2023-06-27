package com.bogatovnikita.ridechronicles.data.retrofit

import com.bogatovnikita.ridechronicles.data.retrofit.models.CarForList
import com.bogatovnikita.ridechronicles.domain.models.Car
import com.bogatovnikita.ridechronicles.domain.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("cars/list")
    fun getListCars(@Query("page") page: Int): Call<List<CarForList>>

    @GET("car/{id}")
    fun getCar(@Path("id") carId: Long): Call<Car>

    @GET("car/{id}/posts")
    fun getListPost(@Path("id") carId: Long): Call<List<Post>>
}