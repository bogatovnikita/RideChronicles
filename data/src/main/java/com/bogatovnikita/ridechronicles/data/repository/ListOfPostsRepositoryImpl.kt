package com.bogatovnikita.ridechronicles.data.repository

import com.bogatovnikita.ridechronicles.data.retrofit.ApiService
import com.bogatovnikita.ridechronicles.domain.models.Avatar
import com.bogatovnikita.ridechronicles.domain.models.Post
import com.bogatovnikita.ridechronicles.domain.models.User
import com.bogatovnikita.ridechronicles.domain.repository.ListOfPostsRepository
import retrofit2.awaitResponse
import javax.inject.Inject

class ListOfPostsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    ListOfPostsRepository {
    override suspend fun getListOfPost(id: Long): List<Post> {
        val response = apiService.getListPost(id).awaitResponse()
        return if (response.isSuccessful && response.body() !== null) {
            response.body()!!.posts.map {
                Post(
                    id = it.id,
                    text = it.text,
                    author = User(
                        id = it.id,
                        username = it.author.username,
                        avatar = Avatar(url = it.author.avatar.url)
                    ),
                    date = it.createdAt,
                    commentCount = it.commentCount,
                    likeCount = it.likeCount,
                    image = it.img
                )
            }
        } else {
            emptyList()
        }
    }
}