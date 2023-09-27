package com.example.flashcardapp.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.flashcardapp.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){

    val navController = LocalNavController.current
    TopAppBar(title = { Text( text = "Welcome User!") }, navigationIcon = {
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "back")
        }
    })
}