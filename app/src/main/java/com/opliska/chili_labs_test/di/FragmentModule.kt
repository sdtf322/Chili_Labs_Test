package com.opliska.chili_labs_test.di

import android.os.Handler
import android.os.Looper
import com.opliska.chili_labs_test.presentation.ImageAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {
    @Provides
    fun provideImageAdapter(): ImageAdapter {
        return ImageAdapter()
    }
    @Provides
    fun provideHandler(): Handler {
        return Handler(Looper.getMainLooper())
    }
}