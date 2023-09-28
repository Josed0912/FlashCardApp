package com.example.flashcardapp.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flashcardapp.model.NavBarIcon
import com.example.flashcardapp.model.Routes

val items = listOf(NavBarIcon(route = Routes.Main.route, icon = Icons.Filled.Home),
        NavBarIcon(route= Routes.About.go(), icon = Icons.Filled.Info),
        NavBarIcon(route = Routes.Contact.go(), icon = Icons.Filled.Phone),
        NavBarIcon(route = Routes.Register.Login.go(), icon = Icons.Filled.Person)
)
@Composable
fun BottomBar(){

    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{
                    currentDestination.route?.substringBefore("/")==
                    item.route.substringBefore("/")} == true
                ,
                onClick = { navController.navigate(item.route)},
                icon = { Icon(item.icon, contentDescription = item.route) })

        }
    }
}
