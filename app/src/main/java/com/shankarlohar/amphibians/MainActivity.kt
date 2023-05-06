package com.shankarlohar.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shankarlohar.amphibians.ui.AmphibiansApp
import com.shankarlohar.amphibians.ui.theme.AmphibiansTheme
import com.shankarlohar.amphibians.ui.view.AmphibiansViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansTheme {
                // A surface container using the 'background' color from the theme
                val viewModel : AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
                AmphibiansApp(viewModel)
                }
            }
        }
    }

