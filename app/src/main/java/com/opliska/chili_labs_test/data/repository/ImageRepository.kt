package com.opliska.chili_labs_test.data.repository

import com.opliska.chili_labs_test.data.DataObject
import com.opliska.chili_labs_test.data.network.ImageApi

class ImageRepository(
    private val imageApi: ImageApi,
    private val userQuery: String
) {

//    suspend fun getRaceList(): List<RaceModel>

    suspend fun getImageList(): List<DataObject> {

        val dataResult = imageApi.getSearchResult(query = userQuery)

        return dataResult.result
    }
}