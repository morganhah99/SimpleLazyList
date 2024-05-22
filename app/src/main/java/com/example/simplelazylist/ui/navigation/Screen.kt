package com.example.simplelazylist.ui.navigation

sealed class Screen(val route: String) {

    object DogImageScreen: Screen("dog_image_screen")

    object RandomDogImageScreen: Screen("random_dog_image_screen")




}