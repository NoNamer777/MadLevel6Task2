package com.nonamer777.madlevel6task2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nonamer777.madlevel6task2.R
import com.nonamer777.madlevel6task2.databinding.ItemMovieBinding
import com.nonamer777.madlevel6task2.model.Movie

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMovieBinding.bind(itemView)

        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        fun bind(movie: Movie) {
            binding.labelMovieListPosition.text = context.getString(
                R.string.movie_list_position,
                adapterPosition.toString()
            )

            Glide.with(context).load(movie.getPosterUrl()).into(binding.imgMoviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_movie,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])
}
