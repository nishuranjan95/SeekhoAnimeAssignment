package com.example.seekhoanimeassignment.data.repository

import com.example.seekhoanimeassignment.data.api.ApiService
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TopRatedRepositoryImpl(private val apiService: ApiService): TopRatedRepository {
    override suspend fun getTopRatedAnime(): Flow<TopRatedResponse> =
        flow {
            emit(apiService.getTopAnime())
        }

}