package com.bogatovnikita.ridechronicles.ui.details_screen

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.adapters.PostAdapter
import com.bogatovnikita.ridechronicles.adapters.ViewPagerAdapter
import com.bogatovnikita.ridechronicles.databinding.FragmentDetailsCarBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsCarFragment : Fragment(R.layout.fragment_details_car) {

    private val binding: FragmentDetailsCarBinding by viewBinding()
    private val args by navArgs<DetailsCarFragmentArgs>()
    private val viewModel: DetailsCarViewModel by viewModels()

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var postAdapter: PostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateState(args.carId)
        initObserver()
        initAdapters()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.screenState.collect { state ->
                renderState(state)
            }
        }
    }

    private fun renderState(state: DetailsCarState) {
        loaderIsEnable(state)
        if (state.isLoaded) {
            viewPagerAdapter.setData(state.someCar.listUrl)
            binding.dotsIndicator.attachTo(binding.viewPagerContainer)
            binding.headTitle.text = state.someCar.name
            val avatar = state.listPosts.firstOrNull()?.author?.avatar?.url
            if (avatar != null) {
                binding.userAvatar.loadImageFromUrl(avatar)
            } else {
                binding.userAvatar.setImageResource(R.mipmap.ic_launcher_round)
            }

            binding.userName.text = state.listPosts.firstOrNull()?.author?.username ?: ""

            postAdapter.setData(state.listPosts)
        }

    }

    private fun loaderIsEnable(state: DetailsCarState) {
        binding.groupDontLoad.isVisible = state.isLoaded
        binding.loader.isVisible = !state.isLoaded
    }

    private fun initAdapters() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPagerContainer.adapter = viewPagerAdapter

        postAdapter = PostAdapter()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = postAdapter
    }
}

fun ImageView.loadImageFromUrl(url: String) {
    val glide = Glide.with(context)
        .load(url)
    glide.into(this)
}