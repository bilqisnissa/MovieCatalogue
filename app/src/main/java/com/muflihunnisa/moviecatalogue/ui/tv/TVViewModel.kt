package com.muflihunnisa.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muflihunnisa.moviecatalogue.BuildConfig
import com.muflihunnisa.moviecatalogue.model.tv.TvResultItem
import com.muflihunnisa.moviecatalogue.model.tv.TvPopularResponse
import com.muflihunnisa.moviecatalogue.model.tv.TvTopRatedResponse
import com.muflihunnisa.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVViewModel : ViewModel() {
    fun init (page: Int){
        getPopularTv(page)
    }

    //Data
    private val dataPopularTv = MutableLiveData<List<TvResultItem?>?>()

    private fun getPopularTv(page: Int) {
        RetrofitConfig().getApiService().getPopularTv(BuildConfig.API_KEY, page)
                .enqueue(object : Callback<TvPopularResponse>{
                    override fun onFailure(call: Call<TvPopularResponse>, t: Throwable) {
                        Log.e("failure", t.toString())
                    }

                    override fun onResponse(call: Call<TvPopularResponse>, response: Response<TvPopularResponse>) {
                        if (response.isSuccessful){
                            val responseTvPopular: TvPopularResponse? = response.body()
                            dataPopularTv.postValue(responseTvPopular?.results)
                        }
                    }


                })
    }
    //get al attribut
    fun getTvPopularData(): LiveData<List<TvResultItem?>?>{
        return dataPopularTv
    }

    //call page
    fun initUp(page: Int){
        getTopRated(page)
    }

    private val dataTopRated = MutableLiveData<List<TvResultItem?>?>()

    private fun getTopRated(page: Int) {
        RetrofitConfig().getApiService().getTopRated(BuildConfig.API_KEY, page)
                .enqueue(object : Callback<TvTopRatedResponse>{
                    override fun onFailure(call: Call<TvTopRatedResponse>, t: Throwable) {
                        Log.e("failure", t.toString())
                    }

                    override fun onResponse(call: Call<TvTopRatedResponse>, response: Response<TvTopRatedResponse>) {
                        if (response.isSuccessful){
                            val topRatedResponse: TvTopRatedResponse? = response.body()
                            dataTopRated.postValue(topRatedResponse?.results)
                        }
                    }


                })
    }
    fun getDataTopRated(): LiveData<List<TvResultItem?>?>{
        return dataTopRated
    }
}