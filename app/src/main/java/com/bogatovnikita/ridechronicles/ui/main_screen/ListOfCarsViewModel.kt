package com.bogatovnikita.ridechronicles.ui.main_screen

import androidx.lifecycle.viewModelScope
import com.bogatovnikita.ridechronicles.base.BaseViewModel
import com.bogatovnikita.ridechronicles.domain.usecase.GetListOfCar
import com.bogatovnikita.ridechronicles.models.CarForList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfCarsViewModel @Inject constructor(private val getListOfCar: GetListOfCar) :
    BaseViewModel<ListOfCarsState>(ListOfCarsState()) {

    fun getListOfCar(page: Int) {
        isNotLoaded()
        viewModelScope.launch {
            updateState {
                it.copy(
                    listCars = getListOfCar.getListOfCar(page).map { item ->
                        CarForList(
                            id = item.id,
                            name = item.name,
                            urlPhoto = item.urlPhoto
                        )
                    },
                    page = page,
                    isLoaded = true
                )
            }
        }
    }

    private fun isNotLoaded() {
        updateState {
            it.copy(
                isLoaded = false,
                listCars = emptyList()
            )
        }
    }
}