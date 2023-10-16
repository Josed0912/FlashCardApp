package com.example.flashcardapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashcardapp.ProfileData
import com.example.flashcardapp.model.Topic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimpleViewModel : ViewModel()
{
    private val _topics = mutableStateListOf<Topic>()
    val topics : List<Topic>
        get() = _topics

    fun add(item : Topic){
        _topics.add(item)
    }

    fun remove(item : Topic){
        _topics.remove(item)
    }

    //preferences data store

    private val _uiState = MutableStateFlow(ProfileData())

    val uiState: StateFlow<ProfileData> = _uiState.asStateFlow()

    fun increment() {
        viewModelScope.launch {
            _uiState.update { it.copy(counter = it.counter + 1) }
        }
    }
}