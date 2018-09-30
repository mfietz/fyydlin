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
        @Json(name = "xmlURL") val xmlUrl: String,
        @Json(name = "htmlURL")val htmlUrl: String,
        @Json(name = "imgURL") val imageUrl: String,
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
        @Json(name = "lastpub") val lastPubDate: Date,
        val rank: Int,
        @Json(name = "url_fyyd") val urlFyyd: String,
        val description: String,
        val subtitle: String,
        @Json(name = "count_episodes") val countEpisodes: Int
)

data class MetaData(
        val paging: Paging,
        @Json(name = "API_INFO") val apiInfo: ApiInfo,
        @Json(name = "SERVER") val server: String,
        val duration: Int
)

data class Paging(
        val count: Int,
        val page: Int,
        @Json(name = "first_page") val firstPage: Int,
        @Json(name = "last_page") val lastPage: Int,
        @Json(name = "next_page") val nextPage: Int?,
        @Json(name = "prev_page") val prevPage: Int?
)

data class ApiInfo(
        @Json(name = "API_VERSION") val apiVersion: Double
)