package com.shankarlohar.amphibians.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.shankarlohar.amphibians.network.AmphibiansApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AppContainer{
    val amphibiansInfoRepository: AmphibiansInfoRepository
}

class AmphibiansAppContainer : AppContainer{

    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService: AmphibiansApiService by lazy{
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansInfoRepository: AmphibiansInfoRepository by lazy{
        NetworkAmphibiansInfoRepository(retrofitService)
    }
}