package com.shankarlohar.amphibians.data

import com.shankarlohar.amphibians.model.AmphibianInfo
import com.shankarlohar.amphibians.network.AmphibiansApiService

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansInfo(): List<AmphibianInfo>
}

class NetworkAmphibiansInfoRepository(
    private val amphibiansApiService: AmphibiansApiService
): AmphibiansInfoRepository{
    override suspend fun getAmphibiansInfo(): List<AmphibianInfo>  =
        amphibiansApiService.getAmphibiansInfo()
}