package com.bogatovnikita.ridechronicles.domain.repository

import com.bogatovnikita.ridechronicles.domain.models.Post

interface ListOfPostsRepository {
    suspend fun getListOfPost(id: Long): List<Post>
}