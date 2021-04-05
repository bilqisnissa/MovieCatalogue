package com.muflihunnisa.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muflihunnisa.moviecatalogue.R
import com.muflihunnisa.moviecatalogue.adapter.TvPopularAdapter
import com.muflihunnisa.moviecatalogue.adapter.TvTopRatedAdapter
import com.muflihunnisa.moviecatalogue.model.tv.TvResultItem
//import com.muflihunnisa.moviecatalogue.adapter.TvAdapter
//import com.muflihunnisa.moviecatalogue.model.movie.ResultsItem
import kotlinx.android.synthetic.main.fragment_tv.*

class TVFragment : Fragment() {
    private lateinit var TvTopRatedAdapter: TvTopRatedAdapter
    private lateinit var popularTvPopularAdapter: TvPopularAdapter
    private lateinit var tvViewModel: TVViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel =
                ViewModelProvider(this).get(TVViewModel::class.java)

        tvViewModel.init(1)
        tvViewModel.initUp(1)
        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, Observer { tvPopular -> getInitTvPopular(tvPopular)})
        tvViewModel.getDataTopRated().observe(viewLifecycleOwner, Observer { tvTopRated -> getInitTopRated(tvTopRated) })
        return root
    }

    private fun getInitTopRated(tvTopRated: List<TvResultItem?>?){
        rv_top_rated.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            TvTopRatedAdapter = TvTopRatedAdapter(tvTopRated)
            rv_top_rated.adapter = TvTopRatedAdapter
        }
    }

    private fun getInitTvPopular(tvPopular: List<TvResultItem?>?) {
        rv_popular_tv.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularTvPopularAdapter = TvPopularAdapter(tvPopular)
            rv_popular_tv.adapter = popularTvPopularAdapter
        }
    }

}