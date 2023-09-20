package com.example.flashcardapp.model

class Topic (name : String){
    var Name : String = name
    val FlashCards : List<FlashCard> = mutableListOf<FlashCard>()
}