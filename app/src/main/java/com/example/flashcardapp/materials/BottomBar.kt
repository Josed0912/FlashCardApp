package com.example.flashcardapp.materials

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar(){
    val selectedIndex = rememberSaveable { mutableIntStateOf(0) }

    BottomNavigation(backgroundColor = Color.Cyan)
    {
        BottomNavigationItem(selected = selectedIndex.value == 0,
            onClick = { selectedIndex.value = 0 },
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "home",
                tint = if (selectedIndex.value == 0) Color.LightGray else Color.Black)
            }
        )


        BottomNavigationItem(selected = selectedIndex.value == 1,
            onClick = { selectedIndex.value = 1 },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "person",
                tint = if (selectedIndex.value == 1) Color.LightGray else Color.Black) })
    }
}
