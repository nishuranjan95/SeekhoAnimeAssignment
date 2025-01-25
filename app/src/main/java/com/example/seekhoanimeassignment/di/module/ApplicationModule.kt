package com.example.seekhoanimeassignment.di.module

import android.content.Context
import com.example.seekhoanimeassignment.SeekhoApplication
import com.example.seekhoanimeassignment.data.api.ApiService
import com.example.seekhoanimeassignment.data.repository.AnimeDetailsRepository
import com.example.seekhoanimeassignment.data.repository.AnimeDetailsRepositoryImpl
import com.example.seekhoanimeassignment.data.repository.TopRatedRepository
import com.example.seekhoanimeassignment.data.repository.TopRatedRepositoryImpl
import com.example.seekhoanimeassignment.di.ApplicationContext
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: SeekhoApplication) {


    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @Singleton
    @Provides
    fun getService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun getTopRepository(apiService: ApiService):TopRatedRepository{
        return TopRatedRepositoryImpl(apiService)
    }

    @Provides
    fun getDetailsRepository(apiService: ApiService):AnimeDetailsRepository{
        return AnimeDetailsRepositoryImpl(apiService)
    }

}