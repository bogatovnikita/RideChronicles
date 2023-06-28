package com.bogatovnikita.ridechronicles.ui.main_screen

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.adapters.CarListAdapter
import com.bogatovnikita.ridechronicles.databinding.FragmentListOfCarsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CarListFragment : Fragment(R.layout.fragment_list_of_cars) {

    private val binding: FragmentListOfCarsBinding by viewBinding()
    private val viewModel: CarListViewModel by viewModels()
    private lateinit var adapter: CarListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListOfCar(viewModel.screenState.value.page)
        initObserver()
        initRecyclerView()
        initClickListener()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.screenState.collect { state ->
                renderState(state)
            }
        }
    }

    private fun renderState(state: CarListState) {
        loaderIsEnable(state)
        binding.numberPage.text = state.page.toString()
        if (state.isLoaded) {
            adapter.setData(state.listCars)
        }
        if (viewModel.screenState.value.page == 1) binding.prevPage.isVisible = false
        if (viewModel.screenState.value.page == 22) binding.nextPage.isVisible = false
    }

    private fun loaderIsEnable(state: CarListState) {
        binding.recyclerView.isVisible = state.isLoaded
        binding.loader.isVisible = !state.isLoaded
        binding.buttonsPageGroup.isVisible = state.isLoaded
    }

    private fun initRecyclerView() {
        adapter = CarListAdapter {
            findNavController().navigate(
                CarListFragmentDirections.actionListOfCarsFragmentToDetailsCarFragment(
                    it
                )
            )
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun initClickListener() {
        binding.nextPage.setOnClickListener {
            viewModel.getListOfCar(viewModel.screenState.value.page + 1)
        }
        binding.prevPage.setOnClickListener {
            viewModel.getListOfCar(viewModel.screenState.value.page - 1)

        }
    }

}