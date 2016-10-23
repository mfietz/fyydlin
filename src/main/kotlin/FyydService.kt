package de.mfietz.fyydlin

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

interface FyydService {

    @GET("/search-pdc/{query}")
    fun findPodcast(@Path("query") query: String): Single<FyydResponse>

    @GET("/search-pdc/{query}/{limit}")
    fun findPodcast(@Path("query") query: String,
                    @Path("limit") limit: String): Single<FyydResponse>

}
