package com.example.seekhoanimeassignment

import android.app.Application
import com.example.seekhoanimeassignment.di.component.ApplicationComponent
import com.example.seekhoanimeassignment.di.component.DaggerApplicationComponent
import com.example.seekhoanimeassignment.di.module.ApplicationModule

class SeekhoApplication:Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDept()
    }

    private fun getDept(){
        applicationComponent=DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}