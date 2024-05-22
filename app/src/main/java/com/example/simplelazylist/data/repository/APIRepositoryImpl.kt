package com.example.simplelazylist.data.repository

import com.example.simplelazylist.data.api.APIEndPoints
import com.example.simplelazylist.data.model.DogFactModel
import com.example.simplelazylist.data.model.DogImageModel
import javax.inject.Inject

class APIRepositoryImpl @Inject constructor(private val apiEndpoints: APIEndPoints): APIRepository {

    override suspend fun getDogImages(): DogImageModel = apiEndpoints.getDogImages()
    override suspend fun getDogFacts(): DogFactModel = apiEndpoints.getDogFacts()



}