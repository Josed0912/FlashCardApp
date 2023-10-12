package com.example.flashcardapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.R
import com.example.flashcardapp.layout.LocalNavController
import com.example.flashcardapp.layout.LocalTopicList
import com.example.flashcardapp.layout.MainLayout
import com.example.flashcardapp.model.Routes
import com.example.flashcardapp.model.Topic
import com.example.flashcardapp.model.TopicIcon


@Composable
fun TopicFormScreen()
{
    val topics = LocalTopicList.current
    val navController = LocalNavController.current
    val subjects = listOf(TopicIcon("Art", R.drawable.art),
        TopicIcon("English", R.drawable.english),
        TopicIcon("French", R.drawable.french),
        TopicIcon("Geography", R.drawable.geography),
        TopicIcon("History", R.drawable.history),
        TopicIcon("Math", R.drawable.math),
        TopicIcon("Music", R.drawable.music),
        TopicIcon("Science", R.drawable.science))

    val selectedIcon = rememberSaveable {mutableStateOf(0)}
    val expanded = rememberSaveable { mutableStateOf(false)}

    MainLayout(actionButton = {})
    {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.height(500.dp)
        )
        //Add validation:
        //Check for the length of the name of the topic (20 characters)
        //Check that the name is unique.
        {
            Column(modifier = Modifier.padding(20.dp)){
                var nameValue by rememberSaveable{ mutableStateOf("") }

                Text("Name of the topic:")
                Spacer(modifier = Modifier.height(10.dp))
                TextField(value = nameValue,
                    onValueChange = {nameValue = it},
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("Icon:")
                Spacer(modifier = Modifier.height(10.dp))
                ElevatedCard(modifier = Modifier.width(200.dp).clickable(onClick = {expanded.value = true})){
                    Text(text=subjects[selectedIcon.value].Name)
                }
                //Add something (COMPOSABLE, button/label) to modify the expanded value
                DropdownMenu(expanded = expanded.value,
                    onDismissRequest = {expanded.value = false})

                    {
                    for (i in 0..subjects.count() - 1)
                    {
                        DropdownMenuItem(onClick = {
                            selectedIcon.value = i
                            expanded.value = false
                        }) {
                            Text(subjects[i].Name)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = {
                    topics.add(Topic(nameValue, subjects[selectedIcon.value]))
                    navController.navigate(Routes.Main.route)
                }){
                    Text("Add")
                }
            }

        }
    }


}