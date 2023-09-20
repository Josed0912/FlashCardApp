package com.example.flashcardapp.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class FlashCard (question : String, answer : String, topic : String){
    val Question : String = question;
    val Answer : String = answer;
    val Topic : String = topic;
}