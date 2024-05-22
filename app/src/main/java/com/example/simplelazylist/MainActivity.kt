package com.example.simplelazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.simplelazylist.ui.theme.SimpleLazyListTheme
import com.example.simplelazylist.ui.viewmodel.SimpleListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleLazyListTheme {
                SimpleList()
            }
        }
    }
}


@Composable
fun SimpleList(viewModel: SimpleListViewModel = hiltViewModel()) {
    val dogImageModel by viewModel.dogImageList.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        dogImageModel.listOfDogs?.let { messages ->
            items(messages) { imageUrl ->
                imageUrl?.let { ItemCard(it) }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemCard(imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            ) {
                it
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)

            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun PreviewItemCard() {
    ItemCard(imageUrl = "https:\\/\\/images.dog.ceo\\/breeds\\/cotondetulear\\/100_2397.jpg\"")
}


