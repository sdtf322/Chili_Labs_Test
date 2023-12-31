package com.opliska.chili_labs_test.data.network

import com.opliska.chili_labs_test.BuildConfig
import com.opliska.chili_labs_test.data.models.DataResult
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = BuildConfig.API_KEY

interface ImageApi {

    @GET("gifs/search")
    suspend fun getSearchResult(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("q") query: String,
        @Query("limit") limit: Int = 20, //Maximum amount of loaded GIFs
        @Query("offset") offset: Int, // Optional offset
        @Query("rating") rating: String = "g", // age rating
        @Query("lang") language: String = "en",
        @Query("bundle") bundle: String = "messaging_non_clips"
    ): DataResult
}