package com.bogatovnikita.ridechronicles.ui.main_screen

import androidx.lifecycle.viewModelScope
import com.bogatovnikita.ridechronicles.base.BaseViewModel
import com.bogatovnikita.ridechronicles.domain.usecase.GetListOfCar
import com.bogatovnikita.ridechronicles.models.CarForListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val getListOfCar: GetListOfCar) :
    BaseViewModel<CarListState>(CarListState()) {

    fun getListOfCar(page: Int) {
        isNotLoaded()
        viewModelScope.launch {
            updateState {
                it.copy(
                    listCars = getListOfCar.getListOfCar(page).map { item ->
                        CarForListModel(
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
                isLoaded = false)
        }
    }
}