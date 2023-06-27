package com.bogatovnikita.ridechronicles.data.retrofit.models

import com.google.gson.annotations.SerializedName

data class Post (
    val id: Long,
    val text: String,

    @SerializedName("like_count")
    val likeCount: Long,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("comment_count")
    val commentCount: Long,

    val img: String,
    val author: User
)