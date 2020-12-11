package com.nonamer777.madlevel6task2.api

import com.nonamer777.madlevel6task2.service.ITheMovieDatabaseService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TheMovieDatabaseApi {

    companion object {

        private val BASE_URL = "https://api.themoviedb.org/3/discover/"

        fun createAPI(): ITheMovieDatabaseService {
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val theMovieDatabaseApi = Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return theMovieDatabaseApi.create(ITheMovieDatabaseService::class.java)
        }
    }
}
