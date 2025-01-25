package com.example.seekhoanimeassignment.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.seekhoanimeassignment.data.repository.AnimeDetailsRepository
import com.example.seekhoanimeassignment.data.repository.TopRatedRepository
import com.example.seekhoanimeassignment.di.ActivityContext
import com.example.seekhoanimeassignment.ui.DetailsViewModel
import com.example.seekhoanimeassignment.ui.MainViewModel
import com.example.seekhoanimeassignment.ui.ViewModelFractory
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity:AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun getTopViewModel(repository: TopRatedRepository):MainViewModel{
        return ViewModelProvider(activity,ViewModelFractory(repository))[MainViewModel::class]
    }

    @Provides
    fun getDetailsViewModel(repository: AnimeDetailsRepository):DetailsViewModel{
        return ViewModelProvider(activity,ViewModelFractory(repository))[DetailsViewModel::class]
    }
}