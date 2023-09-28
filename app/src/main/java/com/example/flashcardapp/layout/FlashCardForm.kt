package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.model.FlashCard

//Make into a separate page
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardForm(index : Int){
    val topic = LocalTopicList.current[index]
    val navController = LocalNavController.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(60.dp)
    )
    {
        Column(modifier = Modifier.padding(20.dp)){
            var questionValue by rememberSaveable {mutableStateOf("")}
            var answerValue by rememberSaveable { mutableStateOf("")}

            Text("Question:")
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = questionValue,
                onValueChange = {questionValue = it})
            Spacer(modifier = Modifier.height(10.dp))
            Text("Answer")
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = answerValue,
                onValueChange = {answerValue = it})
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                topic.addCard(FlashCard( questionValue, answerValue))
                navController.popBackStack()
                //Error When you add a flashcard you need to go back to the topic page
            }){
                Text("Add")
            }
        }
    }
}