package com.opliska.chili_labs_test.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opliska.chili_labs_test.data.models.ImageModel
import com.opliska.chili_labs_test.databinding.ItemImageBinding

class ImageAdapter : ListAdapter<ImageModel, ImageAdapter.ImageViewHolder>(ImageItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(inflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageModel) {
            // Load the image using Glide or your preferred image loading library
            Glide.with(itemView.context)
                .load(item.url)
                .into(binding.imageItem)
        }
    }

    private class ImageItemDiffCallback : DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem == newItem
        }
    }
}