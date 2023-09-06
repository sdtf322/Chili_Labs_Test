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

    private var offset = 0

    private var mutableLiveDataImageList = MutableLiveData<List<ImageModel>>()
    var liveDataImageList: LiveData<List<ImageModel>> = mutableLiveDataImageList

    private var mutableLiveDataUserInput = MutableLiveData<String>()
    var liveDataUserInput: LiveData<String> = mutableLiveDataUserInput

    private lateinit var userInput: String

    //Loads image list with new user query
    suspend fun getNewImageList() {
        if(userInput.isNotEmpty()) {
            try {
                offset = 0
                val imageList = getImageListUseCase(userInput, offset)

                mutableLiveDataImageList.postValue(imageList)
                liveDataImageList = mutableLiveDataImageList
            } catch (e: IOException) {
                println(e.message)
            } catch (e: HttpException) {
                println(e.message)
            }
        }
    }

    //Adds more items to current search query
    suspend fun addOffsetItems() {
        if(userInput.isNotEmpty()) {
            try {
                val imageList = getImageListUseCase(userInput, offset)
                val currentList = mutableLiveDataImageList.value.orEmpty()
                val updatedList = currentList + imageList

                mutableLiveDataImageList.postValue(updatedList)

                offset += 20

                liveDataImageList = mutableLiveDataImageList
            } catch (e: IOException) {
                println(e.message)
            } catch (e: HttpException) {
                println(e.message)
            }
        }
    }

    fun setUserInput(editTextValue: String) {
        userInput = editTextValue
    }
}