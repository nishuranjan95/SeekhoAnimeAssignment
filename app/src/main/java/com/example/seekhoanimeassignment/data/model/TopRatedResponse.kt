package com.example.seekhoanimeassignment.data.model

data class TopRatedResponse(
    var data: List<TopRatedData>?=null,
    var pagination: Pagination?=null
)

data class TopRatedData(
    var mal_id:Int?=0,
    var duration: String? = "",
    var episodes: Int? = 0,
    var favorites: Int? = 0,
    var images: Images? = null,
    var score: String? = null,
    var popularity: Int? = 0,
    var rank: Int? = 0,
    var rating: String? = "",
    var title: String? = "",
    var type: String? = "",
    var url: String? = "",
    var year: Int? = 0
)

data class Images(
    var jpg: Jpg? = null,
    var webp: Webp? = null
)

data class Jpg(
    var image_url: String? = null,
    var large_image_url: String? = null,
    var small_image_url: String? = null
)

data class Webp(
    var image_url: String? = null,
    var large_image_url: String? = null,
    var small_image_url: String? = null
)

data class Pagination(
    var current_page: Int? = null,
    var has_next_page: Boolean? = null,
    var items: Items? = null,
    var last_visible_page: Int? = null
)

data class Items(
    var count: Int? = null,
    var total: Int? = null,
    var per_page: Int? = null
)