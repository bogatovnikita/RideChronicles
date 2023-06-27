package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.domain.models.Post
import com.bogatovnikita.ridechronicles.domain.repository.ListOfPostsRepository

class ListOfPostsRepositoryImpl : ListOfPostsRepository {
    override suspend fun getListOfPost(id: Long): List<Post> {
        TODO("Not yet implemented")
    }
}