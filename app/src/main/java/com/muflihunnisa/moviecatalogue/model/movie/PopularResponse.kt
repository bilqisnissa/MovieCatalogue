package com.muflihunnisa.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName
import com.muflihunnisa.moviecatalogue.model.movie.MovieItemResponse

data class PopularResponse(
        @SerializedName("page")
        val page:Int,
        @SerializedName("results")
        val result: ArrayList<MovieItemResponse>

)


