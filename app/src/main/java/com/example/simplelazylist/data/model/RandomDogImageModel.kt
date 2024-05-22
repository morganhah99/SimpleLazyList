package com.example.simplelazylist.data.model


import com.google.gson.annotations.SerializedName

data class RandomDogImageModel(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("status")
    val status: String? = ""
)