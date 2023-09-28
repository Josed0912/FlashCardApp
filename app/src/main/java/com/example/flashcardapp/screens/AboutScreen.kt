package com.example.flashcardapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flashcardapp.layout.MainLayout

@Composable
fun AboutScreen(modifier : Modifier = Modifier)
{
    MainLayout(actionButton = {}, modifier = modifier) {
        Text("About")
    }
}