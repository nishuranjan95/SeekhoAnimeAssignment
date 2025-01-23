package com.example.seekhoanimeassignment.data.repository

import com.example.seekhoanimeassignment.data.api.ApiService
import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeDetailsRepositoryImpl(private val apiService: ApiService): AnimeDetailsRepository {

    override suspend fun getAnimeDetail(): Flow<AnimeDetailResponse> =
        flow {
        emit(apiService.getTopAnimeDetails())
    }

}