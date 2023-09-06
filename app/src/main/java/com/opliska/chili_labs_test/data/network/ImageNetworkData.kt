package com.opliska.chili_labs_test.data.network

import com.opliska.chili_labs_test.data.models.DataResult
import javax.inject.Inject

class ImageNetworkData @Inject constructor() : ImageApi {

    override suspend fun getSearchResult(
        apiKey: String,
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String,
        bundle: String
    ): DataResult {
        return RetrofitInstance.api.getSearchResult(query = query, offset = offset)
    }
}