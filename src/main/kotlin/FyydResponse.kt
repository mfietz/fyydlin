package de.mfietz.fyydlin

import com.squareup.moshi.Json
import java.util.*

data class FyydResponse(
        val status: Int,
        val msg: String,
        val meta: MetaData,
        val data: List<SearchHit>
)

data class SearchHit(
        val title: String,
        val id: Int,
        @field:Json(name = "xmlURL") val xmlUrl: String,
        @field:Json(name = "htmlURL")val htmlUrl: String,
        @field:Json(name = "imgURL") val imageUrl: String,
        val status: Int,
        val slug: String,
        val layoutImageUrl: String,
        val thumbImageURL: String,
        val smallImageURL: String,
        val microImageURL: String,
        val language: String,
        val lastpoll: String,
        val generator: String,
        val categories: IntArray,
        @field:Json(name = "lastpub") val lastPubDate: Date,
        val rank: Int,
        @field:Json(name = "url_fyyd") val urlFyyd: String,
        val description: String,
        val subtitle: String,
        val author: String,
        @field:Json(name = "count_episodes") val countEpisodes: Int
)

data class MetaData(
        val paging: Paging,
        @field:Json(name = "API_INFO") val apiInfo: ApiInfo,
        @field:Json(name = "SERVER") val server: String,
        val duration: Int
)

data class Paging(
        val count: Int,
        val page: Int,
        @field:Json(name = "first_page") val firstPage: Int,
        @field:Json(name = "last_page") val lastPage: Int,
        @field:Json(name = "next_page") val nextPage: Int?,
        @field:Json(name = "prev_page") val prevPage: Int?
)

data class ApiInfo(
        @field:Json(name = "API_VERSION") val apiVersion: Double
)
