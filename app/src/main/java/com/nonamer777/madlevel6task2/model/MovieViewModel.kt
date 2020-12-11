package com.nonamer777.madlevel6task2.model

import android.app.Application
import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nonamer777.madlevel6task2.repository.MovieRepository
import com.nonamer777.madlevel6task2.repository.exception.FetchMoviesError
import kotlinx.coroutines.launch
import java.util.*

class MovieViewModel(application: Application): AndroidViewModel(application) {

    companion object {

        var isFetchingMovies = MutableLiveData(false)
    }

    private val movieRepo = MovieRepository()

    private val _error: MutableLiveData<String> = MutableLiveData()

    val error: LiveData<String> get() = _error

    val movies = movieRepo.movies

    var movie: Movie? = null

    fun getPopularMoviesByYear(year: String) {
        if (!isValidYear(year)) return

        isFetchingMovies.value = true

        viewModelScope.launch {
            try { movieRepo.getPopularMoviesOfYear(year.toInt()) } catch (error: FetchMoviesError) {
                _error.value = error.message

                isFetchingMovies.value = false

                Log.e("Fetch movies exception", error.cause.toString())
            }
        }
    }

    private fun isValidYear(yearStr: String): Boolean {
        if (yearStr.isBlank()) {
            _error.value = "Please provide a valid year"

            return false
        }
        if (!yearStr.isDigitsOnly()) {
            _error.value = "Please provide a valid year"

            return false
        }
        val year = yearStr.toInt()
        val calender = Calendar.getInstance()

        /*
         * `year < 1890` poked around a bit in their database and it seems like that there are
         * no entries before this year.
         */
        if (year < 1878) {
            _error.value = "Please provide a year where movies where produced"

            return false
        }
        else if (year > calender.get(Calendar.YEAR)) {
            _error.value = "Please provide a year from the past"

            return false
        }
        return true
    }
}
