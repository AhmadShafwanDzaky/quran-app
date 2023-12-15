package com.d121211053.quranapplication.ui.activities.main

import android.content.Intent
import android.graphics.fonts.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211053.quranapplication.R
import com.d121211053.quranapplication.data.models.Data
import com.d121211053.quranapplication.data.models.Hadith
import com.d121211053.quranapplication.ui.activities.detail.HadithDetailActivity
import com.d121211053.quranapplication.ui.theme.QuranApplicationTheme
import com.d121211053.quranapplication.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
//    val customFontFamily = FontFamily.Builder(R.font).build()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranApplicationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "HadithApp", fontFamily = fontFamily, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) }
                        )
                    },
                ) {
                    Column(modifier = Modifier.padding(it)) {
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
        LazyColumn(modifier = modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
            items(data) { data ->
                HadithCard(data = data)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    @Composable
    private fun HadithCard(data: Hadith, modifier: Modifier = Modifier) {
        Card(modifier = Modifier.clickable {
            val intent = Intent(this, HadithDetailActivity::class.java)
            intent.putExtra("HADITH", data)
            startActivity(intent)
        }, colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(text = "Hadith ke-" + data.number ?: "ga tau lagi dah, pen beli truk", fontFamily= fontFamily, fontSize = 32.sp)
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Outlined.ArrowForward,
                    contentDescription = "arrow", Modifier.size(32.dp))
            }
        }
    }
    }

