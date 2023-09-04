package com.opliska.chili_labs_test.data.models

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data")
    val result: List<DataObject>
)
