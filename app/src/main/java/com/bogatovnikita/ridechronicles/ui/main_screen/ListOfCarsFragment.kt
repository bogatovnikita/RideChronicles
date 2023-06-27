package com.bogatovnikita.ridechronicles.ui.main_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.adapters.CarsOfListAdapter
import com.bogatovnikita.ridechronicles.databinding.FragmentListOfCarsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListOfCarsFragment : Fragment(R.layout.fragment_list_of_cars) {

    private val binding: FragmentListOfCarsBinding by viewBinding()
    private val viewModel: ListOfCarsViewModel by viewModels()
    private lateinit var adapter: CarsOfListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListOfCar(viewModel.screenState.value.page)
        initRecyclerView()
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.screenState.collect { state ->
                renderState(state)
            }
        }
    }

    private fun renderState(state: ListOfCarsState) {
        loaderIsEnable(state)
        adapter.submitList(state.listCars)
    }

    private fun loaderIsEnable(state: ListOfCarsState) {
        binding.recyclerView.isVisible = state.isLoaded
        binding.loader.isVisible = !state.isLoaded
    }

    private fun initRecyclerView() {
        adapter = CarsOfListAdapter {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

}