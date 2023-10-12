package com.example.flashcardapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    private var _count by mutableStateOf(0)
    val count : Int
        get() = _count
    fun increment(){
        _count += 1
    }
}