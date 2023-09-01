package com.opliska.chili_labs_test.data

import com.google.gson.annotations.SerializedName

data class DataImage(
    @SerializedName("original")
    val imageModel: ImageModel
)
