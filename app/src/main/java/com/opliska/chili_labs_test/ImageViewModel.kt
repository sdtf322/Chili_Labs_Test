package com.opliska.chili_labs_test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    private val inputSizeMutableLiveData = MutableLiveData<String>()

    val inputSizeLiveData: LiveData<String> = inputSizeMutableLiveData

    fun setUserSearch(userInput: String) {
        inputSizeMutableLiveData.value = userInput
    }
}