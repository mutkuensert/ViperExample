package com.mutkuensert.viperexample.popularmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mutkuensert.viperexample.databinding.MovieColumnItemBinding

class PopularMoviesAdapter(
    private val movies: List<Movie>,
    private val onClickMovie: (id: Int) -> Unit,
) :
    RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {
    class ViewHolder(val binding: MovieColumnItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieColumnItemBinding
            .inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = movies[position]
        val binding = viewHolder.binding
        binding.setItemClickListener(movie.id)
        binding.movieName.text = movie.title

        binding.showProgressBar()
        binding.image.load(movie.image) {
            listener(onSuccess = { _, _ ->
                binding.hideProgressBar()
                binding.showImageView()
            }, onError = { _, _ ->
                binding.hideProgressBar()
            })
        }
    }

    private fun MovieColumnItemBinding.setItemClickListener(id: Int) {
        root.setOnClickListener {
            onClickMovie(id)
        }
    }

    private fun MovieColumnItemBinding.showImageView() {
        image.visibility = View.VISIBLE
    }

    private fun MovieColumnItemBinding.showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun MovieColumnItemBinding.hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun getItemCount() = movies.size

}