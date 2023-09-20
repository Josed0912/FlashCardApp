package com.example.flashcardapp.materials

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.model.Topic

@Composable
fun TopicDisplay(topic : Topic)
{
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = topic.Name,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Left
        )
        Text(
            text = "FlashCards: ${topic.FlashCards.count()}",
            modifier = Modifier.padding(16.dp)
        )
    }
}