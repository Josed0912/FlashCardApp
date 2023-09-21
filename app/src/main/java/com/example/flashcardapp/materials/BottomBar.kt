package com.example.flashcardapp.materials

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomBar(navController:NavController, selectedIndex : Int){

    val selectedIndex = rememberSaveable{mutableIntStateOf(selectedIndex)}

    BottomNavigation(backgroundColor = Color.Cyan)
    {
        BottomNavigationItem(selected = selectedIndex.value == 0,
            onClick = {
                selectedIndex.value = 0
                navController.navigate("MainScreenRoute/${selectedIndex.value}")
                      },
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "home",
                tint = if (selectedIndex.value == 0) Color.LightGray else Color.Black)
            }
        )

        BottomNavigationItem(selected = selectedIndex.value == 1,
            onClick = {
                selectedIndex.value = 1
                //navController.navigate("AccountScreenRoute")
                      },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "person",
                tint = if (selectedIndex.value == 1) Color.LightGray else Color.Black) })

        BottomNavigationItem(selected = selectedIndex.value == 2,
            onClick = {
                selectedIndex.value = 2
                navController.navigate("AboutScreenRoute/${selectedIndex.value}")
                      },
            icon = { Icon(imageVector = Icons.Default.Info,
                contentDescription = "info",
                tint = if (selectedIndex.value == 2) Color.LightGray else Color.Black
            ) })

        BottomNavigationItem(selected = selectedIndex.value == 3,
            onClick = {
                selectedIndex.value = 3
                navController.navigate("ContactScreenRoute/${selectedIndex.value}")
                      },
            icon = { Icon(imageVector = Icons.Default.Email,
                contentDescription = "contact",
                tint = if (selectedIndex.value == 3) Color.LightGray else Color.Black
            ) })
    }
}
