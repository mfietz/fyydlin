package de.mfietz.fyydlin

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Single

interface FyydService {

    @GET("/search/podcast")
    fun searchPodcasts(@Query("title") title: String,
                       @Query("count") limit: Int?): Single<FyydResponse>


}
