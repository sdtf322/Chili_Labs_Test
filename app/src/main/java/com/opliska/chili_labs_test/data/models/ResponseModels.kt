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

data class MetaResult(
    @SerializedName("meta")
    val result: MetaInfo
)
data class MetaInfo(
    val msg: String,
    val response_id: String,
    val status: Int
)