package com.opliska.chili_labs_test.domain

import com.opliska.chili_labs_test.data.models.DataObject

interface ImageRepository {

    suspend fun getImageList(userQuery: String, offset: Int): List<DataObject>
}