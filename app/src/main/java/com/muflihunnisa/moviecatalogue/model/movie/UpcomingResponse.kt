package com.muflihunnisa.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName

data class UpcomingResponse(
		@SerializedName("poster_path")
		val poster_path:String,
		@SerializedName("title")
		val title:String,
		@SerializedName("release_date")
		val release_date:String,
		@SerializedName("overview")
		val overview:String

)

