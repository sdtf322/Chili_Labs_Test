package com.opliska.chili_labs_test.data.network

import com.opliska.chili_labs_test.data.DataResult
import java.lang.Exception

private const val RETROFIT = "Retrofit"

class ImageNetworkData() : ImageApi {

    override suspend fun getSearchResult(
        apiKey: String,
        query: String,
        limit: String,
        offset: String,
        rating: String,
        language: String,
        bundle: String
    ): DataResult {
        return RetrofitInstance.api.getSearchResult(query = query)
    }
}



//    override fun getSearchResult(
//        apiKey: String,
//        query: String,
//        limit: String,
//        offset: String,
//        rating: String,
//        language: String,
//        bundle: String
//    ): Call<DataResult> {
//
//        val call = RetrofitInstance.api.getSearchResult(apiKey, query = userQuery, limit, offset, rating, language, bundle)
//
//        call.enqueue(object: Callback<DataResult> {
//            override fun onResponse(call: Call<DataResult>, response: Response<DataResult>) {
//                if(response.isSuccessful) {
//                    val dataResult = response.body()
//                } else {
//                    Log.d(RETROFIT, "Response is unsuccessful")
//                }
//            }
//
//            override fun onFailure(call: Call<DataResult>, t: Throwable) {
//                Log.d(RETROFIT, "Network failute")
//            }
//        })
//
//        return call
//    }