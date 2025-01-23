package com.example.seekhoanimeassignment.di.component

import com.example.seekhoanimeassignment.MainActivity
import com.example.seekhoanimeassignment.di.ActivityScope
import com.example.seekhoanimeassignment.di.module.ActivityModule
import dagger.Component


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}