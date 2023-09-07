package com.opliska.chili_labs_test.data.network

import com.opliska.chili_labs_test.BuildConfig
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import retrofit2.Retrofit

class RetrofitInstanceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: ImageApiService

    @Before
    fun setUp(){
       mockWebServer = MockWebServer()
        service = ImageApiService()
    }

    @Test
    fun testImageApiService() {
        val query = "cats"
        runBlocking {
            val response = service.getSearchResult(query = query, offset = 0)
            val responseBody = response.result
            assert(responseBody.isNotEmpty())
        }
    }

    @Test
    fun testImageApiServiceWithEmptyQuery() {
        val query = ""
        runBlocking {
            val response = service.getSearchResult(query = query, offset = 0)
            val responseBody = response.result
            assert(responseBody.isEmpty())
        }
    }
}