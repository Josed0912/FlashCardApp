package com.example.flashcardapp.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.flashcardapp.LocalNavController
import com.example.flashcardapp.layout.EmptyTopicDisplay
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.layout.TopicDisplay
import com.example.flashcardapp.model.Topic

@Composable
fun MainScreen(selectedIndex : Int, modifier : Modifier = Modifier, )
{
    val topics = rememberSaveable{ mutableListOf<Topic>()}
    val new = rememberSaveable { mutableStateOf(false) }

    val updateNew : (Boolean) -> Unit =
        {
            new.value = it
        }

    val addToList : (Topic) -> Unit = {
        topics.add(it)
    }
    MainLayout(
        actionButton = {
            FloatingActionButton(onClick = {new.value = true})
            {
                Icon(Icons.Filled.Add, "Add Button")
            }
                       },
        selectedIndex = selectedIndex)
    {
        val navController = LocalNavController.current
        if (new.value) {
            EmptyTopicDisplay(addToList, updateNew)
        }
        else{
            LazyVerticalGrid(
                modifier = modifier,
                columns = GridCells.Fixed(2)
            ) {
                items(topics.count())
                { topic ->
                    TopicDisplay(topics[topic])
                }
            }
        }
    }

}
