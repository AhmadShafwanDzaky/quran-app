package com.d121211053.quranapplication.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211053.quranapplication.data.models.Data
import com.d121211053.quranapplication.data.models.Hadith
import com.d121211053.quranapplication.ui.theme.QuranApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(2.dp)) {
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListNewsScreen(mainViewModel.mainUiState)
                    }
                }
            }
        }
    }
    @Composable
    private fun ListNewsScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when(mainUiState) {
            is MainUiState.Success -> ListHadith(mainUiState.hadith.hadiths)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    private fun ListHadith(data: List<Hadith>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(data) { data ->
                HadithCard(data = data)
            }
        }
    }

    @Composable
    private fun HadithCard(data: Hadith, modifier: Modifier = Modifier) {
        Column {
            Text(text = data.arab ?: "ga tau lagi dah, pen beli truk")
        }
    }
    }

