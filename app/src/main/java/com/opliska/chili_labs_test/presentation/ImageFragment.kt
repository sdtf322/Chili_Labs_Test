package com.opliska.chili_labs_test.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.opliska.chili_labs_test.databinding.FragmentImageBinding
import kotlinx.coroutines.runBlocking

class ImageFragment : Fragment() {

    private lateinit var imageViewModel: ImageViewModel

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    private val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvBenchmark
        val layoutManager = GridLayoutManager(requireActivity(), 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = imageAdapter

        imageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]

        imageViewModel.liveDataImageList.observe(viewLifecycleOwner, Observer { newImageList ->
            imageAdapter.submitList(newImageList)
        })
        runBlocking {
            imageViewModel.getImageList("Formula 1")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}