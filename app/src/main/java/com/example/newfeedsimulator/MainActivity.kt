package com.example.newfeedsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newfeedsimulator.ui.theme.NewFeedSimulatorTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewFeedSimulatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: NewsViewModel = viewModel()
                    val newsList by viewModel.newsList.collectAsState()
                    val readCount by viewModel.readCount.collectAsState()

                    Column(modifier = Modifier.padding(innerPadding)) {

                        Text("Jumlah dibaca: $readCount")

                        LazyColumn {
                            items(newsList) { news ->
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text("📰 ${news.title}")
                                    Text("Kategori: ${news.category}")

                                    Button(onClick = { viewModel.markAsRead() }) {
                                        Text("Tandai Dibaca")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewFeedSimulatorTheme {
        Greeting("Android")
    }
}