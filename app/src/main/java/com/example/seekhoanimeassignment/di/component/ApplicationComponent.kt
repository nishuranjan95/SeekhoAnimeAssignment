package com.example.seekhoanimeassignment.di.component

import android.content.Context
import com.example.seekhoanimeassignment.SeekhoApplication
import com.example.seekhoanimeassignment.data.api.ApiService
import com.example.seekhoanimeassignment.data.repository.TopRatedRepository
import com.example.seekhoanimeassignment.di.ApplicationContext
import com.example.seekhoanimeassignment.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: SeekhoApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getRepository():TopRatedRepository
    fun getApiService():ApiService
}