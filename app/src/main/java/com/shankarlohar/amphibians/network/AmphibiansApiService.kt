package com.shankarlohar.amphibians.network

import com.shankarlohar.amphibians.model.AmphibianInfo
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibiansInfo(): List<AmphibianInfo>
}