package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.models.ImageModel
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(private val imageRepository: ImageRepository) {
    suspend operator fun invoke(userInput: String, offset: Int): List<ImageModel> {

        val dataObjectList = imageRepository.getImageList(userQuery = userInput, offset = offset)

        val imageList: ArrayList<ImageModel> = arrayListOf()

        dataObjectList.forEach {
            imageList.add(it.images.imageModel)
        }

        return imageList
    }
}