package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.nonamer777.madlevel6task2.databinding.FragmentDetailsBinding
import com.nonamer777.madlevel6task2.model.MovieViewModel

/**
 * A [Fragment] subclass that shows the selected movie's details.
 */
class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private val movieViewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailsBinding.inflate(layoutInflater)

        binding.headerTitle.text = movieViewModel.movie?.title
        binding.labelReleaseDate.text = movieViewModel.movie?.releaseDate
        binding.spanAverageRating.text = movieViewModel.movie?.rating.toString()
        binding.paragraphOverview.text = movieViewModel.movie?.overview

        Glide.with(requireContext().applicationContext)
            .load(movieViewModel.movie?.getPosterUrl())
            .into(binding.imgPoster)

        Glide.with(requireContext().applicationContext)
            .load(movieViewModel.movie?.getBackdropUrl())
            .into(binding.imgBackdrop)

        return binding.root
    }
}
