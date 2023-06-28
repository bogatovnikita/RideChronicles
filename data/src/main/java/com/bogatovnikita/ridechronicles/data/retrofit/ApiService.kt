package com.bogatovnikita.ridechronicles.data.retrofit

import com.bogatovnikita.ridechronicles.data.retrofit.models.CarDataResponse
import com.bogatovnikita.ridechronicles.data.retrofit.models.CarForListData
import com.bogatovnikita.ridechronicles.data.retrofit.models.PostDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("cars/list")
    fun getListCars(@Query("page") page: Int): Call<List<CarForListData>>

    @GET("car/{id}")
    fun getCar(@Path("id") carId: Long): Call<CarDataResponse>

    @GET("car/{id}/posts")
    fun getListPost(@Path("id") carId: Long): Call<PostDataResponse>
}