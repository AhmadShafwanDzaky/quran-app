package com.d121211053.quranapplication.ui.activities.main

import com.d121211053.quranapplication.MyApplication
import com.d121211053.quranapplication.data.models.Data
import com.d121211053.quranapplication.data.models.Hadith
import com.d121211053.quranapplication.data.repository.HadithRepository
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val hadith: Data) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val HadithRepository: HadithRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getNews() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = HadithRepository.getHadith(
                range = "1-150"
            )
//            Log.d("MainViewModel", "getNews: ${result.data.size}")
            mainUiState = MainUiState.Success(result.data)
        } catch (e: IOException) {
            Log.d("MainViewMode", "getNews error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getNews()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val newsRepository = application.container.hadithRepository
                MainViewModel(newsRepository)
            }
        }
    }

}