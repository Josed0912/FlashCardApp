package com.example.flashcardapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flashcardapp.layout.MainLayout

@Composable
fun SignUpScreen(selectedIndex : Int){
    MainLayout(actionButton = {}, selectedIndex = selectedIndex) {
        Text("Sign Up Page")
    }
}