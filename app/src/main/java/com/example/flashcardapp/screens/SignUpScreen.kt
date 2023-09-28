package com.example.flashcardapp.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun SignUpScreen(){

    val navController = LocalNavController.current

    MainLayout(actionButton = {}) {


        var usernameValue by rememberSaveable { mutableStateOf("") }
        var passwordValue by rememberSaveable { mutableStateOf("") }
        var confirmedPasswordValue by rememberSaveable { mutableStateOf("") }

        //Add validation:
        //Check that the length of the password is at least 8 characters with one uppercase one lowercase one number and one symbol
        //Check that the confirm password is the same as the password

        Text("Sign Up Page", fontSize = 36.sp)
        Spacer(Modifier.height(16.dp))
        Text("Username")
        TextField(value = usernameValue,
            onValueChange = {usernameValue = it})

        Spacer(Modifier.height(16.dp))
        Text("Password")
        TextField(value = passwordValue,
            onValueChange = {passwordValue = it})

        Spacer(Modifier.height(16.dp))
        Text("Confirm Password")
        TextField(value = confirmedPasswordValue,
            onValueChange = {confirmedPasswordValue = it})

        Row{
            Button(onClick = {navController.navigate(Routes.Main.route)}){
                Text("Sign Up")
            }
        }
    }
}