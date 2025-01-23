package com.example.seekhoanimeassignment.data.model

data class AnimeDetailResponse(
    var data: AnimeDetailData? = null
)

data class AnimeDetailData(
    var images: Images? = Images(),
    var licensors: List<Licensor>? = listOf(),
    var popularity: Int? = 0,
    var producers: List<Producer>? = listOf(),
    var rank: Int? = 0,
    var studios: List<Studio>? = listOf(),
    var trailer: Trailer? = Trailer(),
    var synopsis: String? = "",
    var title: String? = "",
    var genres: List<Genre>? = listOf(),
    var episodes: Int? = 0,
    var duration: String? = "",
    var rating: String? = "",
    var score: String? = null,
)

data class Trailer(
    var embed_url: String? = "",
    var images: Images? =null,
    var url: String? = "",
    var youtube_id: String? = ""
)

data class Genre(
    var mal_id: Int? = null,
    var name: String? = null,
    var type: String? = null,
    var url: String? = null
)

data class Licensor(
    var mal_id: Int? = null,
    var name: String? = null,
    var type: String? = null,
    var url: String? = null
)

data class Producer(
    var mal_id: Int? = null,
    var name: String? = null,
    var type: String? = null,
    var url: String? = null
)

data class Studio(
    var mal_id: Int? = null,
    var name: String? = null,
    var type: String? = null,
    var url: String? = null
)