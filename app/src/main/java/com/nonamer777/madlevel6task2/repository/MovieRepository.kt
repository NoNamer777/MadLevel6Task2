package com.nonamer777.madlevel6task2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nonamer777.madlevel6task2.model.Movie
import com.nonamer777.madlevel6task2.repository.exception.FetchMoviesError
import com.nonamer777.madlevel6task2.service.ITheMovieDatabaseService
import com.nonamer777.madlevel6task2.api.TheMovieDatabaseApi
import com.nonamer777.madlevel6task2.model.MovieResponse
import kotlinx.coroutines.withTimeout

class MovieRepository {

    private val theMovieDatabaseApi: ITheMovieDatabaseService = TheMovieDatabaseApi.createAPI()

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>> get() = _movies

    suspend fun getPopularMoviesOfYear(year: Int) {
        try {
            val result: MovieResponse = withTimeout(5_000) {
                theMovieDatabaseApi.getPopularMoviesOfYear(year)
            }
            _movies.value = result.results

        } catch (error: Throwable) {
            throw FetchMoviesError("Unable to get the movies", error)
        }
    }
}
