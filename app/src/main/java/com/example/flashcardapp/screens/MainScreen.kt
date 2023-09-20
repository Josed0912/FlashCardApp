package com.example.flashcardapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.flashcardapp.materials.BottomBar
import com.example.flashcardapp.materials.EmptyTopicDisplay
import com.example.flashcardapp.materials.TopicDisplay
import com.example.flashcardapp.model.Topic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen( navController: NavController, modifier : Modifier = Modifier){

    val topics = rememberSaveable{ mutableListOf<Topic>()}
    val new = rememberSaveable { mutableStateOf(false) }

    val updateNew : (Boolean) -> Unit =
        {
            new.value = it
        }

    val addToList : (Topic) -> Unit = {
        topics.add(it)
    }

    Scaffold (
        topBar = {
            TopAppBar(title = { Text("Welcome User!") } )
        },
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {new.value = true}) {
                Icon(Icons.Filled.Add, "Add Button")
            }
        },

        ) {
        LazyVerticalGrid (
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(2),
        ){
            items(topics.count())
            {
                    topic ->
                TopicDisplay(topics[topic])
            }
        }
    }
    if (new.value) {
        EmptyTopicDisplay(addToList, updateNew)
    }
}
