package com.example.seekhoanimeassignment.data.repository

import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import kotlinx.coroutines.flow.Flow

interface TopRatedRepository {

    suspend fun getTopRatedAnime():Flow<TopRatedResponse>

}