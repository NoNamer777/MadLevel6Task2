package com.nonamer777.madlevel6task2.service

import com.nonamer777.madlevel6task2.BuildConfig
import com.nonamer777.madlevel6task2.model.Movie
import com.nonamer777.madlevel6task2.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ITheMovieDatabaseService {

    @GET("movie?api_key=${BuildConfig.THE_MOVIE_DATABASE_KEY}&language=en-US&sort_by=popularity.desc&with_original_language=en")
    suspend fun getPopularMoviesOfYear(@Query("year") year: Int): MovieResponse
}
