package com.example.flashcardapp.model

sealed class Routes (val route: String){
    object Main : Routes("MainScreenRoute")
    object About: Routes("AboutScreenRoute"){
        fun go() = "AboutScreenRoute"
    }
    object Contact: Routes("ContactScreenRoute"){
        fun go() = "ContactScreenRoute"
    }
    object Register: Routes ("Register"){
        object Login : Routes("Register/Login"){
            fun go() = "Register/Login"
        }
        object SignUp : Routes("Register/SignUp")
    }

    object TopicForm: Routes("TopicForm")
    object FlashCardForm: Routes("FlashCardForm")

    object TopicPage: Routes("Topic")
}