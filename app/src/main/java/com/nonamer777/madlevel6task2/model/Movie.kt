package com.nonamer777.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("vote_average")
    val rating: Double
) {

    fun getPosterUrl() = "https://image.tmdb.org/t/p/w185$posterPath"
}
