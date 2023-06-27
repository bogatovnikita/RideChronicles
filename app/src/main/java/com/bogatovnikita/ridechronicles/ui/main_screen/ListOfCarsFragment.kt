package com.bogatovnikita.ridechronicles.ui.main_screen

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bogatovnikita.ridechronicles.R
import com.bogatovnikita.ridechronicles.databinding.FragmentListOfCarsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfCarsFragment : Fragment(R.layout.fragment_list_of_cars) {
    private val binding: FragmentListOfCarsBinding by viewBinding()

}