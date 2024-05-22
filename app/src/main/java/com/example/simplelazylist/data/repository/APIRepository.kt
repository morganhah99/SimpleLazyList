package com.example.simplelazylist.data.repository

import com.example.simplelazylist.data.model.DogFactModel
import com.example.simplelazylist.data.model.DogImageModel

interface APIRepository {

    suspend fun getDogImages(): DogImageModel

    //suspend fun getDogFacts(): DogFactModel
}