package com.nonamer777.madlevel6task2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nonamer777.madlevel6task2.R
import com.nonamer777.madlevel6task2.databinding.FragmentOverviewBinding
import com.nonamer777.madlevel6task2.model.Movie
import com.nonamer777.madlevel6task2.model.MovieViewModel

/**
 * A [Fragment] subclass where Users can input a year and see the most
 * popular English spoken movies of that year.
 */
class OverviewFragment: Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    private val movieViewModel: MovieViewModel by activityViewModels()

    private val popularMovies = arrayListOf<Movie>()

    private val movieAdapter = MovieAdapter(popularMovies, ::onMovieClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOverviewBinding.inflate(layoutInflater)

        initializeRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val year = binding.inputYear.editableText.toString()

            movieViewModel.getPopularMoviesByYear(year)
        }
    }

    private fun initializeRecyclerView() {
        binding.moviesList.layoutManager = GridLayoutManager(
            activity,
            2,
            GridLayoutManager.VERTICAL,
            false
        )
        binding.moviesList.adapter = movieAdapter

        observeFetchedMovies()
    }

    private fun onMovieClick(movie: Movie) {
        movieViewModel.movie = movie

        findNavController().navigate(R.id.action_overviewFragment_to_detailsFragment)
    }

    private fun observeFetchedMovies() {
        movieViewModel.movies.observe(viewLifecycleOwner, {
            popularMovies.clear()
            popularMovies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })

        movieViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })

        MovieViewModel.isFetchingMovies.observe(viewLifecycleOwner, {
            binding.progressBar.visibility = when (it) {
                true -> View.VISIBLE
                else -> View.INVISIBLE
            }
        })
    }
}
