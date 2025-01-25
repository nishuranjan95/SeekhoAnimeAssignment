package com.example.seekhoanimeassignment.data.api

import com.example.seekhoanimeassignment.data.model.AnimeDetailResponse
import com.example.seekhoanimeassignment.data.model.TopRatedResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v4/top/anime")
    suspend fun getTopAnime():TopRatedResponse

    @GET("v4/anime/{anime_id}")
    suspend fun getTopAnimeDetails(@Path("anime_id") mailId: String):AnimeDetailResponse
}