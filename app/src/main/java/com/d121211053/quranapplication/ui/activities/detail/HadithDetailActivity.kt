package com.d121211053.quranapplication.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.d121211053.quranapplication.data.models.Data
import com.d121211053.quranapplication.data.models.Hadith
import com.d121211053.quranapplication.ui.activities.main.MainViewModel
import com.d121211053.quranapplication.ui.theme.QuranApplicationTheme
import com.d121211053.quranapplication.ui.theme.fontFamily

class HadithDetailActivity : ComponentActivity() {

    private var selectedHadith: Hadith? = null

    @Composable
    fun HadithDetailScreen(selectedHadith: Hadith?) {
        LazyColumn (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)){
            item {
//                Text(text = "Hadith ke-" + selectedHadith?.number.toString(), fontFamily= fontFamily, fontWeight = FontWeight.Medium, fontSize = 40.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
//                Spacer(modifier = Modifier.height(24.dp))
                Text(text = selectedHadith?.arab.toString(), fontSize = 24.sp, textAlign = TextAlign.End, lineHeight = 2.em)
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Terjemahan", fontFamily= fontFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = selectedHadith?.id.toString(), fontFamily= fontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedHadith = intent.getParcelableExtra("HADITH")
        setContent {
            QuranApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Hadith ke-" + selectedHadith?.number.toString(),
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { onBackPressed() }) {
                                    Icon(
                                        imageVector = Icons.Outlined.ArrowBack,
                                        contentDescription = "Back",
                                        Modifier.size(32.dp)
                                    )
                                }
                            },
                        )
                    }, content =  {
                Column(modifier = Modifier.padding(it)) {
                    val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                    HadithDetailScreen(selectedHadith)
                }
            })
        }
    }



}}