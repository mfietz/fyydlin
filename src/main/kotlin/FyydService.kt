package de.mfietz.fyydlin

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FyydService {

    @GET("search/podcast")
    fun searchPodcasts(@Query("term") term: String,
                       @Query("count") limit: Int?): Single<FyydResponse>


}
