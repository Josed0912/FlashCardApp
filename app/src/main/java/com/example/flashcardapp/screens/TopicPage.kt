package com.example.flashcardapp.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flashcardapp.layout.FlashCardDisplay
import com.example.flashcardapp.layout.LocalNavController
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.model.Routes
import com.example.flashcardapp.viewmodels.SimpleViewModel

@Composable
fun TopicPage(index: Int, simpleViewModel : SimpleViewModel = viewModel()) {
    val topic = simpleViewModel.topics[index]
    val navController = LocalNavController.current

    MainLayout(actionButton = {
        FloatingActionButton(onClick = { navController.navigate(Routes.FlashCardForm.route + "/$index") })
        {
            Icon(Icons.Filled.Add, "Add Button")
        }
    })
    {
        Text("${topic.Name}", fontSize = 48.sp)
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2))
        {
            items(topic.FlashCards.count()) { card ->
                FlashCardDisplay(card = topic.FlashCards[card])
            }
        }
    }
}

