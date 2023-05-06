package com.shankarlohar.amphibians.ui.view

import com.shankarlohar.amphibians.model.AmphibianInfo

sealed interface AmphibiansUiState {
    data class Success(val AmphibiansInfo: List<AmphibianInfo>) : AmphibiansUiState
    object Loading : AmphibiansUiState
    object Error : AmphibiansUiState
}