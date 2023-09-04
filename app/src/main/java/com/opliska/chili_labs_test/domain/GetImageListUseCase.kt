package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.ImageModel
import com.opliska.chili_labs_test.data.repository.ImageRepositoryImpl

class GetImageListUseCase() {
    suspend operator fun invoke(userInput: String): List<ImageModel> {

        val imageRepository = ImageRepositoryImpl()

        val imageRepositoryImageList = imageRepository.getImageList(userQuery = userInput)

        val imageList: ArrayList<ImageModel> = arrayListOf()

        imageRepositoryImageList.forEach {
            imageList.add(it.images.imageModel)
        }
        //returns list of URLs
        return imageList
    }
}