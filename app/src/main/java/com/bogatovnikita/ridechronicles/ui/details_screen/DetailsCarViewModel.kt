package com.bogatovnikita.ridechronicles.ui.details_screen

import androidx.lifecycle.viewModelScope
import com.bogatovnikita.ridechronicles.base.BaseViewModel
import com.bogatovnikita.ridechronicles.domain.usecase.GetListOfPosts
import com.bogatovnikita.ridechronicles.domain.usecase.GetSomeCar
import com.bogatovnikita.ridechronicles.models.Avatar
import com.bogatovnikita.ridechronicles.models.CarModel
import com.bogatovnikita.ridechronicles.models.PostModel
import com.bogatovnikita.ridechronicles.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsCarViewModel @Inject constructor(
    private val getListOfPosts: GetListOfPosts,
    private val getSomeCar: GetSomeCar
) : BaseViewModel<DetailsCarState>(DetailsCarState()) {

    fun updateState(id: Long) {
        isNotLoaded()
        viewModelScope.launch(Dispatchers.IO) {
            val getSomeCarDeferred = async { getSomeCar.getCar(id) }
            val getListOfPostsDeferred = async { getListOfPosts.getListOfPosts(id) }

            val getSomeCarResult = getSomeCarDeferred.await()
            val listOfPosts = getListOfPostsDeferred.await()

            updateState {
                it.copy(
                    someCar = CarModel(
                        id = getSomeCarResult.id,
                        brandName = getSomeCarResult.brandName,
                        modelName = getSomeCarResult.modelName,
                        year = getSomeCarResult.year,
                        engineVolume = getSomeCarResult.engineVolume,
                        listUrl = getSomeCarResult.listUrl
                    ),
                    listPosts = listOfPosts.map { post ->
                        PostModel(
                            id = post.id,
                            text = post.text,
                            author = User(
                                id = post.author.id,
                                username = post.author.username,
                                avatar = Avatar(post.author.avatar.url)
                            ),
                            date = post.date,
                            likeCount = post.likeCount,
                            commentCount = post.commentCount
                        )
                    },
                    isLoaded = true
                )
            }
        }
    }

    private fun isNotLoaded() {
        updateState {
            it.copy(
                isLoaded = false
            )
        }
    }
}