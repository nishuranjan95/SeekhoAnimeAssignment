package com.example.seekhoanimeassignment.data.repository

import com.example.seekhoanimeassignment.data.api.ApiService
import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeDetailsRepositoryImpl(private val apiService: ApiService): AnimeDetailsRepository {

    override suspend fun getAnimeDetail(mail_id: String): Flow<AnimeDetailResponse> =
        flow {
        emit(apiService.getTopAnimeDetails(mail_id))
    }

}