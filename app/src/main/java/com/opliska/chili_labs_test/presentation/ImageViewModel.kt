package com.opliska.chili_labs_test.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.HttpException
import java.io.IOException


//Todo Send UseCase here
class ImageViewModel : ViewModel() {
    private val inputSizeMutableLiveData = MutableLiveData<String>()

    val inputSizeLiveData: LiveData<String> = inputSizeMutableLiveData



    fun setUserSearch(userInput: String) {
        inputSizeMutableLiveData.value = userInput
    }
}

//private val mutableRaceModelList = MutableLiveData<List<RaceModel>>()
//
//suspend fun getAllRaces() {
//
//    try {
//        val raceModelList = getRaceListUseCase()
//        mutableRaceModelList.postValue(raceModelList)
//    } catch(e: IOException) {
//        println(e.message)
//    } catch(e: HttpException) {
//        println(e.message())
//    }
//}
//
//fun getLiveData() : LiveData<List<RaceModel>> {
//    return mutableRaceModelList
//}