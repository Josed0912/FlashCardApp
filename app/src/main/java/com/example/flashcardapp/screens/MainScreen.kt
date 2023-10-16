package com.example.flashcardapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flashcardapp.layout.LocalNavController
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.layout.TopicDisplay
import com.example.flashcardapp.model.Routes
import com.example.flashcardapp.viewmodels.SimpleViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, simpleViewModel : SimpleViewModel = viewModel()) {

    //val topicHandle = LocalTopicList.current

    //val topics = rememberSaveable { topicHandle }

    val topics = rememberSaveable {simpleViewModel.topics}
  
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
        Text("${simpleViewModel.count}")
        Button(onClick = {simpleViewModel.increment()},)
        {
            Text("Increment")
        }
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
