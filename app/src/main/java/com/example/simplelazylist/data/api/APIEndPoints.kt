package com.example.simplelazylist.data.api

import com.example.simplelazylist.data.model.DogImageModel
import retrofit2.http.GET

interface APIEndPoints {

    @GET(APIDetails.END_POINT)
    suspend fun getDogImages(): DogImageModel

}