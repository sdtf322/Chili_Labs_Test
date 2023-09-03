package com.opliska.chili_labs_test.data.repository

import com.opliska.chili_labs_test.data.DataObject
import com.opliska.chili_labs_test.data.network.ImageApi
import com.opliska.chili_labs_test.domain.ImageRepository

class ImageRepositoryImpl(
    private val imageApi: ImageApi,
    private val userQuery: String
) : ImageRepository {
    override suspend fun getImageList(): List<DataObject> {

        val data = imageApi.getSearchResult(query = userQuery)

        return data.result
    }
}