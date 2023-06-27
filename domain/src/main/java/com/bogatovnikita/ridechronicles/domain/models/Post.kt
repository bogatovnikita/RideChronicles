package com.bogatovnikita.ridechronicles.domain.models

data class Post(
    val id: Long = 0L,
    val text: String = "",
    val author: User
)

data class User(
    val id: Long,
    val username: String,
    val avatar: Avatar,
)

data class Avatar(
    val url: String
)