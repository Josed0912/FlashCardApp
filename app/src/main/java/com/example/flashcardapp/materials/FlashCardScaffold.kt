package com.example.flashcardapp.materials

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardScaffold(navController : NavController,
                      actionButton : @Composable() () -> Unit,
                      selectedIndex : Int,
                      content : @Composable() (Modifier) -> Unit)
{
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController, selectedIndex)
        },
        floatingActionButton = actionButton
    ){
        content(Modifier.padding(it))
    }
}