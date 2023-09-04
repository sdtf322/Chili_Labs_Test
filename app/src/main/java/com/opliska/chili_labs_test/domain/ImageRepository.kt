package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.DataObject

interface ImageRepository {

    suspend fun getImageList(userQuery: String): List<DataObject>
}