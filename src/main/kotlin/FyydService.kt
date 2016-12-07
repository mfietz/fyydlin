package de.mfietz.fyydlin

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import rx.Single

interface FyydService {

    @GET("/search-pdc/{query}")
    fun searchPodcasts(@Path("query") query: String): Single<FyydResponse>

    @GET("/search-pdc/{query}/{limit}")
    fun searchPodcasts(@Path("query") query: String,
                       @Path("limit") limit: Int,
                       @Header("Accept-Language") language: String?): Single<FyydResponse>

}
