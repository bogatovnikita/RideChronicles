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
        viewModelScope.launch {
            val getSomeCarResult = getSomeCar.getCar(id)
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
                    isLoadedSomeCar = true
                )
            }
        }

        viewModelScope.launch {
            updateState {
                it.copy(
                    listPosts = getListOfPosts.getListOfPosts(id).map { post ->
                        PostModel(
                            id = post.id,
                            text = post.text,
                            author = User(
                                id = post.author.id,
                                username = post.author.username,
                                avatar = Avatar(
                                    url = post.author.avatar.url
                                )
                            )
                        )
                    }, isLoadedPosts = true
                )
            }
        }
    }

    private fun isNotLoaded() {
        updateState {
            it.copy(
                isLoadedPosts = false,
                isLoadedSomeCar = false
            )
        }
    }
}