package com.example.flashcardapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flashcardapp.model.Topic
import com.example.flashcardapp.materials.BottomBar
import com.example.flashcardapp.materials.TopicDisplay
import com.example.flashcardapp.materials.EmptyTopicDisplay
import com.example.flashcardapp.screens.AboutScreen
import com.example.flashcardapp.screens.ContactScreen
import com.example.flashcardapp.screens.MainScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardApp (modifier: Modifier = Modifier) {
    Router()
}

val LocalNavController = compositionLocalOf<NavController>{error("No NavController found!")}
@Composable
fun Router(){
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "MainScreenRoute/0"){
            composable("MainScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ MainScreen(navController, it.arguments?.getInt("selectedIndex") ?: 0)}
            composable("AboutScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ AboutScreen(navController, it.arguments?.getInt("selectedIndex") ?: 0)}
            composable("ContactScreenRoute/{selectedIndex}",
                arguments = listOf(navArgument("selectedIndex"){type = NavType.IntType})){ ContactScreen(navController, it.arguments?.getInt("selectedIndex") ?: 0)}
        }
    }
}


