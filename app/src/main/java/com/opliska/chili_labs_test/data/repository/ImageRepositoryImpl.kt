package com.opliska.chili_labs_test.data.repository

import com.opliska.chili_labs_test.data.models.DataObject
import com.opliska.chili_labs_test.data.network.ImageApi
import com.opliska.chili_labs_test.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val imageApi: ImageApi) : ImageRepository {
    override suspend fun getImageList(userQuery: String, offset: Int): List<DataObject> {
        val data = imageApi.getSearchResult(query = userQuery, offset = offset)
        return data.result
    }
}