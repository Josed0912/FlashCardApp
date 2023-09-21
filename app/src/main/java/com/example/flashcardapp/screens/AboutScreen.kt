package com.example.flashcardapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.flashcardapp.materials.FlashCardScaffold

@Composable
fun AboutScreen(navController: NavController, selectedIndex : Int, modifier : Modifier = Modifier)
{
    FlashCardScaffold(navController = navController, actionButton = {}, selectedIndex) {
    }
}