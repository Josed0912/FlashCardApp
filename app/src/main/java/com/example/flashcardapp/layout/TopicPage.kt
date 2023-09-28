package com.example.flashcardapp.layout

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable


//To-Do
//Add a button to go back to the main page
//Make this into a separate page
@Composable
fun TopicPage(index : Int)
{
    val topic = LocalTopicList.current[index]

    val new = rememberSaveable { mutableStateOf(false)}

    MainLayout(actionButton = {
        FloatingActionButton(onClick = {new.value = true})
        {
            Icon(Icons.Filled.Add, "Add Button")
        }
    })
    {
        if(new.value){
            FlashCardForm(index)
        }
        else{
            LazyVerticalGrid(columns = GridCells.Fixed(2))
            {
                items(topic.FlashCards.count()){
                        card ->
                    FlashCardDisplay(card = topic.FlashCards[card])
                }
            }
        }

    }
}

