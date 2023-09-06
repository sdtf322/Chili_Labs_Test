package com.opliska.chili_labs_test.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opliska.chili_labs_test.databinding.FragmentImageBinding
import kotlinx.coroutines.launch

class ImageFragment : Fragment() {

    private lateinit var imageViewModel: ImageViewModel

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    private val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

    private val handler by lazy { Handler(Looper.getMainLooper()) }

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

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + firstVisibleItemPosition + THRESHOLD >= totalItemCount && firstVisibleItemPosition >= 0) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        imageViewModel.addOffsetItems()
                    }
                }
            }
        })

        imageViewModel.liveDataImageList.observe(viewLifecycleOwner, Observer { newImageList ->
            imageAdapter.submitList(newImageList)
        })

        binding.etQuery.addTextChangedListener { editable ->
            handler.removeCallbacksAndMessages(null)
            handler.postDelayed({
                imageViewModel.setUserInput(editable.toString().trim())

                viewLifecycleOwner.lifecycleScope.launch {
                    imageViewModel.getNewImageList()
                }
            }, delayMillis)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        handler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val delayMillis = 500L
        private const val THRESHOLD = 5
    }
}