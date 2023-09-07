package com.opliska.chili_labs_test.di

import com.opliska.chili_labs_test.data.network.ImageApi
import com.opliska.chili_labs_test.data.network.ImageApiService
import com.opliska.chili_labs_test.data.repository.ImageRepositoryImpl
import com.opliska.chili_labs_test.domain.GetImageListUseCase
import com.opliska.chili_labs_test.domain.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun provideImageListUseCase(imageRepository: ImageRepository): GetImageListUseCase {
        return GetImageListUseCase(imageRepository)
    }

    @Provides
    fun provideImageRepository(imageApi: ImageApi): ImageRepository {
        return ImageRepositoryImpl(imageApi)
    }

    @Provides
    fun provideImageApi() : ImageApi {
        return ImageApiService()
    }
}