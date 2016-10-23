package de.mfietz.fyydlin

import com.squareup.moshi.Json
import java.util.*

data class FyydResponse(
    val status: Int,
    val msg: String,
    val data: Map<Long, SearchHit>
)

data class SearchHit(
    val title: String,
    val slug: String,
    val language: String,
    @Json(name = "xml_url") val xmlUrl: String,
    @Json(name = "html_url")val htmlUrl: String,
    @Json(name = "img_url") val imageUrl: String,
    val description: String,
    val subtitle: String,
    val categories: Map<Int,Map<Int,String>>,
    val author: String,
    @Json(name = "lastpubdate") val lastPubDate: Date,
    @Json(name = "count_episodes") val countEpisodes: Int
)