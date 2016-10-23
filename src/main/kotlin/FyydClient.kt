package de.mfietz.fyydlin

import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.Single
import java.util.*

class FyydClient(
    baseUrl: String = "https://api.fyyd.de",
    client: OkHttpClient = OkHttpClient()
) {

    val service: FyydService

    init {
        val moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        service = retrofit.create(FyydService::class.java)
    }

    fun findPodcasts(vararg query: String): Single<FyydResponse> {
        return service.findPodcast(query.joinToString(separator = ","))
    }

    fun findPodcasts(vararg query: String, limit: Int): Single<FyydResponse> {
        return service.findPodcast(query.joinToString(separator = ","), limit.toString())
    }

}
