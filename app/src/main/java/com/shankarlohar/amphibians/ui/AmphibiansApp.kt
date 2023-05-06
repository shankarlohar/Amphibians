package com.shankarlohar.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.shankarlohar.amphibians.R
import com.shankarlohar.amphibians.ui.view.AmphibiansViewModel
import com.shankarlohar.amphibians.ui.view.screens.HomeScreen


@Composable
fun AmphibiansApp(viewModel: AmphibiansViewModel, modifier: Modifier = Modifier) {
    
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.app_name)
                    )
                }
            )
        }
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it), color = MaterialTheme.colors.background) {

            val amphibiansViewModel: AmphibiansViewModel = viewModel
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansUiState,
            )
            
        }
    }

}
