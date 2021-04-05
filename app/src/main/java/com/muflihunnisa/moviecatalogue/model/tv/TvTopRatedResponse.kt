package com.muflihunnisa.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvTopRatedResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvResultItem?>?,

	@field:SerializedName("total_results")
	val totalResults: Int
)

