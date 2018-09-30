package de.mfietz.fyydlin

import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class FyydClient @JvmOverloads constructor(
    client: OkHttpClient = defaultClient,
    baseUrl: String = defaultBaseUrl
) {

    companion object FyydClientDefaults {
        private val defaultClient by lazy { OkHttpClient() }
        private val defaultBaseUrl = "https://api.fyyd.de/0.2/"
    }

    constructor(baseUrl: String) : this(client = defaultClient, baseUrl = baseUrl)

    val service: FyydService

    init {
        val moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        service = retrofit.create(FyydService::class.java)
    }

    fun searchPodcasts(title: String, limit: Int? = null): Single<FyydResponse> {
        return service.searchPodcasts(title, limit)
    }

}
