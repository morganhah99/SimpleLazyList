package com.example.simplelazylist.ui.navigation

import DogImageList
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplelazylist.DogFact

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DogImageScreen.route) {
        composable(route = Screen.DogImageScreen.route) {
            DogImageList(navController)

        }

        composable(route = Screen.DogFactScreen.route) {
            DogFact()
        }
    }

}