package com.bogatovnikita.ridechronicles.domain.usecase

import com.bogatovnikita.ridechronicles.domain.models.Post
import com.bogatovnikita.ridechronicles.domain.repository.ListOfPostsRepository
import javax.inject.Inject

class GetListOfPosts @Inject constructor(private val listOfPosts: ListOfPostsRepository) {
    suspend fun getListOfPosts(id: Long): List<Post> = listOfPosts.getListOfPost(id)
}