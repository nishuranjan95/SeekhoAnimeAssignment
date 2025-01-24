package com.example.seekhoanimeassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.seekhoanimeassignment.data.repository.AnimeDetailsRepository
import com.example.seekhoanimeassignment.data.repository.TopRatedRepository


class ViewModelFractory(private val repository: Any):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(repository as TopRatedRepository) as T
        } else if (modelClass.isAssignableFrom(DetailsViewModel::class.java)){
            DetailsViewModel(repository as AnimeDetailsRepository) as T
        } else
            throw IllegalArgumentException("illegal model")
    }
}