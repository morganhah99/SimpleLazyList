package com.example.simplelazylist.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplelazylist.data.model.DogImageModel
import com.example.simplelazylist.data.repository.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SimpleListViewModel @Inject constructor(private val repository: APIRepository): ViewModel() {

    private val _dogImageList = MutableStateFlow(DogImageModel())
    val dogImageList: StateFlow<DogImageModel> = _dogImageList

    init {
        getDogImages()
    }

    private fun getDogImages() {
        viewModelScope.launch {
            Log.d("SimpleListViewModel", "getDogImages called")

            try {

                val dogImages = repository.getDogImages()
                _dogImageList.emit(dogImages)
                Log.d("SimpleListViewModel", "Dog images fetched successfully")

            } catch (e: Exception) {
                Log.e("SimpleListViewModel", "Failed to fetch dog images", e)
            }
        }
    }

}