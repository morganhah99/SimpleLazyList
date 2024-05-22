package com.example.simplelazylist.data.repository

import com.example.simplelazylist.data.model.DogImageModel
import com.example.simplelazylist.data.model.RandomDogImageModel

interface APIRepository {

    suspend fun getDogImages(): DogImageModel

    suspend fun getRandomDogImage(): RandomDogImageModel
}