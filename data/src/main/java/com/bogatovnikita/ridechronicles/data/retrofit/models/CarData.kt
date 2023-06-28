package com.bogatovnikita.ridechronicles.data.retrofit.models

import com.google.gson.annotations.SerializedName

data class CarData(
    val id: Long,

    @SerializedName("for_sale")
    val forSale: Long,

    @SerializedName("brand_name")
    val brandName: String,

    @SerializedName("model_name")
    val modelName: String,

    val year: Long,
    val price: Any? = null,

    @SerializedName("brand_id")
    val brandID: Long,

    @SerializedName("model_id")
    val modelID: Long,

    @SerializedName("engine_id")
    val engineID: Long,

    @SerializedName("transmission_id")
    val transmissionID: Long,

    @SerializedName("place_id")
    val placeID: String,

    val name: String,

    @SerializedName("city_name")
    val cityName: String,

    @SerializedName("country_name")
    val countryName: String,

    @SerializedName("transmission_name")
    val transmissionName: String,

    @SerializedName("place_name")
    val placeName: String,

    val images: List<Image>,

    @SerializedName("in_selection_count")
    val inSelectionCount: Long,

    @SerializedName("followers_count")
    val followersCount: Long,

    val follow: Boolean,
    val engine: String,

    @SerializedName("engine_name")
    val engineName: String,

    @SerializedName("engine_volume")
    val engineVolume: String,

    @SerializedName("is_moderated")
    val isModerated: Boolean
)

data class Image(
    val id: Long,

    @SerializedName("is_primary")
    val isPrimary: Boolean,

    val size: Long,
    val index: Long,
    val url: String,

    @SerializedName("thumbnail_url")
    val thumbnailURL: String,

    val image500: String,
    val image100: String
)

data class User(
    val id: Long,
    val username: String,
    val email: String,
    val about: String,
    val avatar: Avatar,

    @SerializedName("auto_count")
    val autoCount: Long,

    @SerializedName("main_auto_name")
    val mainAutoName: String
)

data class Avatar(
    val path: String,
    val url: String
)

data class CarDataResponse(
    val car: CarData,
    val user: User
)