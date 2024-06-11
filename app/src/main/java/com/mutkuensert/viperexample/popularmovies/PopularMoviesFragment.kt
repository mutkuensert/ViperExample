package com.mutkuensert.viperexample.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mutkuensert.viperexample.R
import com.mutkuensert.viperexample.databinding.FragmentPopularMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PopularMoviesFragment
    : Fragment(R.layout.fragment_popular_movies), PopularMoviesContract.View {

    @Inject
    lateinit var presenter: PopularMoviesContract.Presenter

    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter.bindView(this)
        presenter.setScope(lifecycleScope)
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter.onCreateView()
        return view
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

    override fun showMovies(movies: List<Movie>) {
        val adapter = PopularMoviesAdapter(movies)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}