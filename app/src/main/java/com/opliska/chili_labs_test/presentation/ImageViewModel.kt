package com.opliska.chili_labs_test.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.opliska.chili_labs_test.data.ImageModel
import com.opliska.chili_labs_test.data.repository.ImageRepositoryImpl
import com.opliska.chili_labs_test.domain.GetImageListUseCase
import com.opliska.chili_labs_test.domain.ImageRepository
import retrofit2.HttpException
import java.io.IOException

class ImageViewModel : ViewModel() {

    private val mutableLiveDataImageList = MutableLiveData<List<ImageModel>>()

    private val getImageListUseCase: GetImageListUseCase by lazy { GetImageListUseCase() }

    var liveDataImageList: LiveData<List<ImageModel>> = mutableLiveDataImageList

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