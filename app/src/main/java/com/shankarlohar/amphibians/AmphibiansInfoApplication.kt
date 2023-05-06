package com.shankarlohar.amphibians

import android.app.Application
import com.shankarlohar.amphibians.data.AmphibiansAppContainer
import com.shankarlohar.amphibians.data.AppContainer

class AmphibiansInfoApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AmphibiansAppContainer()
    }
}