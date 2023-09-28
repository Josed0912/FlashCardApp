package com.example.flashcardapp.model

class Topic (name : String){
    var Name : String = name
    val FlashCards : MutableList<FlashCard> = mutableListOf()

    val addCard : (FlashCard) -> Unit = {
        FlashCards.add(it)
    }
}