package com.example.simplelazylist.data.model


import com.google.gson.annotations.SerializedName

data class DogImageModel(
    @SerializedName("message")
    val listOfDogs: List<String?>? = listOf(),
    @SerializedName("status")
    val status: String? = ""
)