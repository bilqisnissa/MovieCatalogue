package com.muflihunnisa.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muflihunnisa.moviecatalogue.BuildConfig
import com.muflihunnisa.moviecatalogue.R
import com.muflihunnisa.moviecatalogue.model.movie.MovieItemResponse
import kotlinx.android.synthetic.main.item_populer_movie.view.*

class PopulerMovieAdapter(var listMovie : List<MovieItemResponse>) : RecyclerView.Adapter<PopulerMovieAdapter.MovieViewHolder>() {
    inner class MovieViewHolder (val view : View) : RecyclerView.ViewHolder(view){
        fun bind (movies : MovieItemResponse){
            with(itemView){
                Glide.with(context)
                        .load(BuildConfig.IMAGE_URL + movies.poster_path)
                        .into(iv_movie_poster)
                tv_title_movie.text = movies.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_populer_movie, parent, false))
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie.get(position))
    }

}