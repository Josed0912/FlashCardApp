package com.example.flashcardapp.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.layout.LocalNavController
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.model.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    MainLayout(actionButton = {}) {

        val navController = LocalNavController.current
        var usernameValue by rememberSaveable { mutableStateOf("")}
        var passwordValue by rememberSaveable { mutableStateOf("")}

        Text("Login Page", fontSize = 36.sp)
        Spacer(Modifier.height(16.dp))
        Text("Username")
        TextField(value = usernameValue,
            onValueChange = {usernameValue = it})

        Spacer(Modifier.height(16.dp))
        Text("Password")
        TextField(value = passwordValue,
            onValueChange = {passwordValue = it})

        Spacer(Modifier.height(16.dp))

        Row{
            Button(onClick = {navController.navigate(Routes.Register.SignUp.route)}){
                Text("Sign Up")
            }
            Spacer(Modifier.width(16.dp))
            Button(onClick = {navController.navigate(Routes.Main.route)}){
                Text("Log In")
            }
        }

    }
}