package com.opliska.chili_labs_test.data.repository

import com.opliska.chili_labs_test.data.models.DataObject
import com.opliska.chili_labs_test.data.network.ImageNetworkData
import com.opliska.chili_labs_test.domain.ImageRepository

class ImageRepositoryImpl() : ImageRepository {
    override suspend fun getImageList(userQuery: String, offset: Int): List<DataObject> {

        val imageApi = ImageNetworkData()
        val data = imageApi.getSearchResult(query = userQuery, offset = offset)

        return data.result
    }
}