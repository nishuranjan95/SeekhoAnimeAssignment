package com.example.seekhoanimeassignment.data.repository

import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import kotlinx.coroutines.flow.Flow

interface AnimeDetailsRepository {

    suspend fun getAnimeDetail(mail_id: String): Flow<AnimeDetailResponse>
}