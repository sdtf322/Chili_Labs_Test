package com.opliska.chili_labs_test.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.opliska.chili_labs_test.data.models.ImageModel
import com.opliska.chili_labs_test.domain.GetImageListUseCase
import retrofit2.HttpException
import java.io.IOException

class ImageViewModel : ViewModel() {

    private val getImageListUseCase: GetImageListUseCase by lazy { GetImageListUseCase() }


    private var mutableLiveDataImageList = MutableLiveData<List<ImageModel>>()
    var liveDataImageList: LiveData<List<ImageModel>> = mutableLiveDataImageList

    private var mutableLiveDataUserInput = MutableLiveData<String>()
    var liveDataUserInput: LiveData<String> = mutableLiveDataUserInput

    suspend fun getImageList(userInput: String) {
        try {
            val imageList = getImageListUseCase(userInput)
            mutableLiveDataImageList.postValue(imageList)
            liveDataImageList = mutableLiveDataImageList
        } catch (e: IOException) {
            println(e.message)
        } catch (e: HttpException) {
            println(e.message)
        }
    }
}