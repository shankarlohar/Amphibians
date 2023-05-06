package com.shankarlohar.amphibians.ui.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shankarlohar.amphibians.AmphibiansInfoApplication
import com.shankarlohar.amphibians.data.AmphibiansInfoRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class AmphibiansViewModel (private val amphibiansInfoRepository: AmphibiansInfoRepository): ViewModel(){
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansInfo()
    }

    private fun getAmphibiansInfo(){
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansInfoRepository.getAmphibiansInfo())
            }catch (e: IOException){
                AmphibiansUiState.Error
            }catch (e: HttpException){
                AmphibiansUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory{
            initializer {
                // This is the error my application
                val application = (this[APPLICATION_KEY] as AmphibiansInfoApplication)
                val amphibiansInfoRepository = application.container.amphibiansInfoRepository
                AmphibiansViewModel(amphibiansInfoRepository = amphibiansInfoRepository)
            }
        }
    }
}