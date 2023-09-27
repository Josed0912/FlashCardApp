package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flashcardapp.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
                      actionButton : @Composable() () -> Unit,
                      selectedIndex : Int,
                      content : @Composable() () -> Unit)
{
    val navController = LocalNavController.current

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(selectedIndex)
        },
        floatingActionButton = actionButton
    ){
        Column(Modifier.padding(it)){
            content()
        }
    }
}