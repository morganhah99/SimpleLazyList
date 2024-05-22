package com.example.simplelazylist.data.api

import com.example.simplelazylist.data.model.DogImageModel
import com.example.simplelazylist.data.model.RandomDogImageModel
import retrofit2.http.GET

interface APIEndPoints {

    @GET(APIDetails.DOG_IMAGE_END_POINT)
    suspend fun getDogImages(): DogImageModel

    @GET(APIDetails.RANDOM_DOG_IMAGE_END_POINT)
    suspend fun getRandomDogImage(): RandomDogImageModel

}