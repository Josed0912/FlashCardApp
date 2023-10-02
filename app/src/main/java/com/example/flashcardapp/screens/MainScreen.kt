package com.example.flashcardapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.layout.LocalNavController
import com.example.flashcardapp.layout.LocalTopicList
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.layout.TopicDisplay
import com.example.flashcardapp.model.Routes

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val topics = LocalTopicList.current
    var navController = LocalNavController.current

    MainLayout(
        actionButton = {
            FloatingActionButton(onClick = { navController.navigate(Routes.TopicForm.route) })
            {
                Icon(Icons.Filled.Add, "Add Button")
            }
        })
    {
        Text("Topics", fontSize = 48.sp)
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2)
        ) {
            items(topics.count())
            { topic ->
                TopicDisplay(topics[topic], Modifier.clickable(onClick = {
                    navController.navigate(Routes.TopicPage.route + "/$topic")
                }))
            }
        }

    }

}
