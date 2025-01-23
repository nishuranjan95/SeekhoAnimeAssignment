package com.example.seekhoanimeassignment.data.api

import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v4/top/anime")
    suspend fun getTopAnime():TopRatedResponse

    @GET("v4/anime/")
    suspend fun getTopAnimeDetails():AnimeDetailResponse
}