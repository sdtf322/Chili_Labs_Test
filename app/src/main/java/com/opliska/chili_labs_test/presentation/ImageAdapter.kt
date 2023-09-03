package com.opliska.chili_labs_test.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opliska.chili_labs_test.data.DataObject
import com.opliska.chili_labs_test.databinding.ItemImageBinding

class ImageAdapter : ListAdapter<DataObject, ImageAdapter.ImageViewHolder>(ImageItemDiffCallback()) {

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

        fun bind(item: DataObject) {
            // Load the image using Glide or your preferred image loading library
            Glide.with(itemView.context)
                .load(item.images.imageModel.url)
                .into(binding.imageItem)
        }
    }

    private class ImageItemDiffCallback : DiffUtil.ItemCallback<DataObject>() {
        override fun areItemsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
            return oldItem.images.imageModel.url == newItem.images.imageModel.url
        }

        override fun areContentsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
            return oldItem == newItem
        }
    }
}