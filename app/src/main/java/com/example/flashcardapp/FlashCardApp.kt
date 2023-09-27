package com.example.flashcardapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flashcardapp.screens.AboutScreen
import com.example.flashcardapp.screens.ContactScreen
import com.example.flashcardapp.screens.LoginScreen
import com.example.flashcardapp.screens.MainScreen
import com.example.flashcardapp.screens.SignUpScreen


@Composable
fun FlashCardApp (modifier: Modifier = Modifier) {
    Router()
}

val LocalNavController = compositionLocalOf<NavController>{error("No NavController found!")}
@Composable
private fun Router(){
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "MainScreenRoute/0"){
            composable("MainScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ MainScreen( it.arguments?.getInt("selectedIndex") ?: 0)}
            navigation(route="Register", startDestination = "Register/Login"){
                composable("Register/Login/{selectedIndex}",
                    arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ LoginScreen(it.arguments?.getInt("selectedIndex") ?: 0 )}
                composable("Register/SignUp/{selectedIndex}",
                    arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ SignUpScreen(it.arguments?.getInt("selectedIndex") ?: 0 )}
            }
            composable("AboutScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ AboutScreen( it.arguments?.getInt("selectedIndex") ?: 0)}
            composable("ContactScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ ContactScreen(it.arguments?.getInt("selectedIndex") ?: 0)}
        }
    }
}


