package com.example.simplelazylist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplelazylist.data.model.RandomDogImageModel
import com.example.simplelazylist.data.repository.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RandomDogImageViewModel @Inject constructor(private val repository: APIRepository): ViewModel() {

    private val _randomDogImage = MutableStateFlow(RandomDogImageModel())
    val randomDogImage: StateFlow<RandomDogImageModel> = _randomDogImage


    init {
        getRandomDogImage()
    }
    private fun getRandomDogImage() {
        viewModelScope.launch {
            val randomDogImage = repository.getRandomDogImage()
            _randomDogImage.emit(randomDogImage)
        }

    }

}