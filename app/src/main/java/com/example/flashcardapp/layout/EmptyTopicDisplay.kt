package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
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
import com.example.flashcardapp.model.Topic

@Composable
fun EmptyTopicDisplay(addTopic : (Topic) -> Unit, updateNew : (Boolean) -> Unit){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(70.dp)
    )
    {
        Column(modifier = Modifier.padding(20.dp)){
            var nameValue by rememberSaveable{ mutableStateOf("") }

            Text("Enter the name of the topic:")
            TextField(value = nameValue,
                onValueChange = {nameValue = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
            )
            Spacer(modifier = Modifier.height(6.dp))
            Button(onClick = {
                addTopic(Topic(nameValue))
                updateNew(false)
            }){
                Text("Submit")
            }
        }

    }
}