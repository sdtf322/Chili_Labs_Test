package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.repository.ImageRepositoryImpl

class GetImageListUseCase() {



    suspend operator fun invoke(): List<String> {

        val imageRepositoryImageList = imageRepository.getImageList()

        val imageList: ArrayList<String> = arrayListOf()

        imageRepositoryImageList.forEach {
            imageList.add(it.images.imageModel.url)
        }

        return imageList

        //returns list of URLs
    }
}