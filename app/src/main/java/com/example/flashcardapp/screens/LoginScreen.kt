package com.example.flashcardapp.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flashcardapp.LocalNavController
import com.example.flashcardapp.layout.MainLayout

@Composable
fun LoginScreen(selectedIndex : Int){
    MainLayout(actionButton = {}, selectedIndex = selectedIndex) {

        val navController = LocalNavController.current

        Text("LoginPage")

        Button(onClick = {navController.navigate("Register/SignUp/${selectedIndex}")}){
            Text("Sign tf Up")
        }
    }
}