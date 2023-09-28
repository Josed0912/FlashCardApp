package com.example.flashcardapp.layout


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(modifier : Modifier = Modifier, actionButton : @Composable() () -> Unit, content : @Composable() () -> Unit)
{
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = actionButton,
    ){
            Column(modifier.padding(it).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                content()
            }
    }
}