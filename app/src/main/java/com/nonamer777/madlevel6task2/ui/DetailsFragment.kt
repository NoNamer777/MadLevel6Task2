package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nonamer777.madlevel6task2.R
import com.nonamer777.madlevel6task2.databinding.FragmentDetailsBinding

/**
 * A [Fragment] subclass that shows the selected movie's details.
 */
class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailsBinding.inflate(layoutInflater)

        return binding.root
    }
}
