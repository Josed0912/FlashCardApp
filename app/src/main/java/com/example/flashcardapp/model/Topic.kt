package com.example.flashcardapp.model

class Topic (name : String, icon : TopicIcon){
    var Name : String = name
    val FlashCards : MutableList<FlashCard> = mutableListOf()
    val Icon : TopicIcon = icon;

    val addCard : (FlashCard) -> Unit = {
        FlashCards.add(it)
    }
}