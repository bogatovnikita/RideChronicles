package com.bogatovnikita.ridechronicles.data.retrofit.models

import com.google.gson.annotations.SerializedName

data class CarForList(
    val id: Long,

    @SerializedName("for_sale")
    val forSale: Long,

    @SerializedName("brand_name")
    val brandName: String,

    @SerializedName("model_name")
    val modelName: String,

    @SerializedName("engine_name")
    val engineName: String,

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
    val image: String,
    val thumbnail: String,

    @SerializedName("city_name")
    val cityName: String,

    @SerializedName("country_name")
    val countryName: String,

    @SerializedName("transmission_name")
    val transmissionName: TransmissionName,

    @SerializedName("engine_volume")
    val engineVolume: String,

    @SerializedName("place_name")
    val placeName: String,

    val images: List<Image>,
    val engine: String
)

enum class TransmissionName(val value: String) {
    At("AT"),
    MT("MT");

    companion object {
        public fun fromValue(value: String): TransmissionName = when (value) {
            "AT" -> At
            "MT" -> MT
            else -> throw IllegalArgumentException()
        }
    }
}
