package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.model.FlashCard

@Composable
fun FlashCardDisplay(card : FlashCard)
{
    ElevatedCard (
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(16.dp))
    {
        Column (modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally){
            Text("Question", modifier = Modifier.padding(8.dp),fontWeight = FontWeight(1000))
            Spacer(Modifier.height(6.dp))
            Text(text = card.Question, modifier = Modifier.padding(8.dp))
            Spacer(Modifier.height(6.dp))
            Text("Answer", modifier = Modifier.padding(8.dp), fontWeight = FontWeight(1000))
            Spacer(Modifier.height(6.dp))
            Text(text = card.Answer, modifier = Modifier.padding(8.dp))
        }

    }
}