package com.opliska.chili_labs_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.opliska.chili_labs_test.data.ImageModel
import com.opliska.chili_labs_test.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    private val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

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

        val imageList: ArrayList<ImageModel> = arrayListOf()
        imageList.add(ImageModel(imageSource = R.drawable.verstappen))
        imageList.add(ImageModel(imageSource = R.drawable.hamilton))
        imageList.add(ImageModel(imageSource = R.drawable.alonso))
        imageList.add(ImageModel(imageSource = R.drawable.verstappenpng))

        imageAdapter.submitList(imageList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}