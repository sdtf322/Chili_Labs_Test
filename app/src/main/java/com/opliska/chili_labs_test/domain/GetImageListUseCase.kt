package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.models.ImageModel
import com.opliska.chili_labs_test.data.repository.ImageRepositoryImpl

class GetImageListUseCase() {
    suspend operator fun invoke(userInput: String, offset: Int): List<ImageModel> {

        val imageRepository = ImageRepositoryImpl()

        val imageRepositoryImageList = imageRepository.getImageList(userQuery = userInput, offset = offset)

        val imageList: ArrayList<ImageModel> = arrayListOf()

        imageRepositoryImageList.forEach {
            imageList.add(it.images.imageModel)
        }
        //returns list of URLs
        return imageList
    }
}