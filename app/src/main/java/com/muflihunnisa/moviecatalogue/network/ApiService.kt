package com.muflihunnisa.moviecatalogue.network

import com.muflihunnisa.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.muflihunnisa.moviecatalogue.model.movie.PopularResponse
import com.muflihunnisa.moviecatalogue.model.tv.TvPopularResponse
import com.muflihunnisa.moviecatalogue.model.tv.TvTopRatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("movie/popular")
        fun getPopularMovie(
                @Query("api_key") apiKey : String,
                @Query("page") page : Int
        ): retrofit2.Call<PopularResponse>

        @GET("movie/upcoming")
        fun getUpcomingMovie(
                @Query("api_key") apiKey : String,
                @Query("page") page : Int
        ): retrofit2.Call<MovieUpcomingItemResponse>

        @GET("tv/top_rated")
        fun getTopRated(
                @Query("api_key") apiKey: String,
                @Query("page") page: Int
        ): retrofit2.Call<TvTopRatedResponse>

        @GET("tv/popular")
        fun getPopularTv(
                @Query("api_key") apiKey: String,
                @Query("page") page: Int
        ): retrofit2.Call<TvPopularResponse>

}