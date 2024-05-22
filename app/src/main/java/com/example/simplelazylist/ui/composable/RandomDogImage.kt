package com.example.simplelazylist.ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.simplelazylist.R
import com.example.simplelazylist.ui.navigation.Screen
import com.example.simplelazylist.ui.navigation.SimpleTopAppBar
import com.example.simplelazylist.ui.viewmodel.RandomDogImageViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RandomDogImage(navController: NavController, viewModel: RandomDogImageViewModel = hiltViewModel()) {
    val randomDogImageViewModel by viewModel.randomDogImage.collectAsState()

    Scaffold(
        topBar = {
            SimpleTopAppBar(
                title = Screen.RandomDogImageScreen.route,
                onNavigationIconClick = {
                    navController.navigate("dog_image_screen")
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            GlideImage(
                model = randomDogImageViewModel.message,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .fillMaxHeight()
            ) {
                it
                    .load(randomDogImageViewModel.message)
                    .placeholder(R.drawable.ic_launcher_foreground)
            }
        }
    }
}
