package com.example.flashcardapp.layout

import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.flashcardapp.model.Routes
import com.example.flashcardapp.model.Topic
import com.example.flashcardapp.screens.AboutScreen
import com.example.flashcardapp.screens.ContactScreen
import com.example.flashcardapp.screens.LoginScreen
import com.example.flashcardapp.screens.MainScreen
import com.example.flashcardapp.screens.SignUpScreen


val LocalNavController = compositionLocalOf<NavController>{error("No NavController found!")}
val LocalTopicList = compositionLocalOf<MutableList<Topic>> {error("No list has been found")}
@Composable
fun Router(){
    val navController = rememberNavController()
    val topicList = mutableListOf<Topic>()

    CompositionLocalProvider(LocalNavController provides navController) {
        CompositionLocalProvider(LocalTopicList provides topicList) {
            NavHost(navController = navController, startDestination = Routes.Main.route){
                composable(Routes.Main.route,
                    enterTransition = {fadeIn()}){ MainScreen() }
                navigation(route=Routes.Register.route, startDestination = Routes.Register.SignUp.route){
                    composable(Routes.Register.Login.route,
                        enterTransition = {fadeIn()}){ LoginScreen() }
                    composable(Routes.Register.SignUp.route,
                        enterTransition = {fadeIn()}){ SignUpScreen() }
                }
                composable(Routes.About.route,
                    enterTransition = {fadeIn()}){ AboutScreen() }
                composable(Routes.Contact.route,
                    enterTransition = {fadeIn()}){ ContactScreen() }
            }
        }
    }
}