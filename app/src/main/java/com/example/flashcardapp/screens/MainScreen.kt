package com.example.flashcardapp.screens

import androidx.compose.foundation.clickable
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
import com.example.flashcardapp.layout.LocalTopicList
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.layout.TopicDisplay
import com.example.flashcardapp.layout.TopicForm
import com.example.flashcardapp.layout.TopicPage

@Composable
fun MainScreen(modifier : Modifier = Modifier)
{
    val topics = LocalTopicList.current
    val new = rememberSaveable { mutableStateOf(false) }
    val selected = rememberSaveable { mutableStateOf(false)}
    var selectedTopic : Int? = null

    val updateNew : (Boolean) -> Unit =
        {
            new.value = it
        }

    MainLayout(
        actionButton = {
            FloatingActionButton(onClick = {new.value = true})
            {
                Icon(Icons.Filled.Add, "Add Button")
            }
        })
    {
        if (new.value) {
            TopicForm(updateNew)
        }
        else if(selected.value){
            TopicPage(selectedTopic!!)
        }
        else{
            LazyVerticalGrid(
                modifier = modifier,
                columns = GridCells.Fixed(2)
            ) {
                items(topics.count())
                { topic ->
                    TopicDisplay(topics[topic], Modifier.clickable(onClick = {
                        selected.value = true
                        selectedTopic = topic
                    }))
                }
            }
        }
    }

}
