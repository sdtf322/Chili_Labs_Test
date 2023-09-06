package com.opliska.chili_labs_test.data.models

import com.google.gson.annotations.SerializedName

data class DataImage(
    @SerializedName("original")
    val imageModel: ImageModel
)

data class DataObject(
    @SerializedName("images")
    val images: DataImage
)

data class DataResult(
    @SerializedName("data")
    val result: List<DataObject>
)

data class ImageModel(
    val url: String
)