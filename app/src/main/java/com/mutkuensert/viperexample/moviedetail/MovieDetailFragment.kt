package com.mutkuensert.viperexample.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.toRoute
import coil.load
import com.mutkuensert.viperexample.R
import com.mutkuensert.viperexample.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail), MovieDetailContract.View {
    @Inject
    lateinit var presenter: MovieDetailContract.Presenter

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var route: MovieDetailContract.Router.MovieDetailRoute

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        route =
            findNavController().currentBackStackEntry?.toRoute<MovieDetailContract.Router.MovieDetailRoute>()!!

        presenter.bindView(this)
        presenter.setScope(lifecycleScope)
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        presenter.onCreateView(route.id)

        presenter.setNavigateBack(
            requireActivity(),
            this,
            findNavController()
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.unbindView()
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showMovie(movie: MovieDetail) {
        binding.movieTitle.text = movie.title
        binding.movieDescription.text = movie.description
        binding.moviePoster.load(movie.image)
    }
}