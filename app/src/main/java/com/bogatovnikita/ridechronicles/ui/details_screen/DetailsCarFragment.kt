package com.bogatovnikita.ridechronicles.ui.details_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.adapters.ViewPagerAdapter
import com.bogatovnikita.ridechronicles.databinding.FragmentDetailsCarBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsCarFragment : Fragment(R.layout.fragment_details_car) {

    private val binding: FragmentDetailsCarBinding by viewBinding()
    private val args by navArgs<DetailsCarFragmentArgs>()
    private val viewModel: DetailsCarViewModel by viewModels()
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateState(args.carId)
        initObserver()
        initViewPagerAdapter()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.screenState.collect { state ->
                renderState(state)
            }
        }
    }

    private fun renderState(state: DetailsCarState) {
        if (state.isLoadedSomeCar && state.isLoadedPosts) viewPagerAdapter.setData(state.someCar.listUrl)
    }

    private fun initViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPagerContainer.adapter = viewPagerAdapter
    }
}