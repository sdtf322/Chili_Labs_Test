package com.opliska.chili_labs_test.data.repository

import com.opliska.chili_labs_test.data.DataObject
import com.opliska.chili_labs_test.data.network.ImageApi
import com.opliska.chili_labs_test.data.network.ImageNetworkData
import com.opliska.chili_labs_test.domain.ImageRepository

class ImageRepositoryImpl() : ImageRepository {
    override suspend fun getImageList(userQuery: String): List<DataObject> {

        val imageApi = ImageNetworkData()
        val data = imageApi.getSearchResult(query = userQuery)

        return data.result
    }
}