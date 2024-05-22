package com.example.simplelazylist.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.simplelazylist.R
import com.example.simplelazylist.ui.viewmodel.RandomDogImageViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RandomDogImage(viewModel: RandomDogImageViewModel = hiltViewModel()) {
    val randomDogImageViewModel by viewModel.randomDogImage.collectAsState()

    GlideImage(
        model = randomDogImageViewModel.message,
        contentDescription = null
    ) {
        it
            .load(randomDogImageViewModel.message)
            .placeholder(R.drawable.ic_launcher_foreground)
    }

}