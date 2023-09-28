package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.model.FlashCard

@Composable
fun FlashCardDisplay(card : FlashCard)
{
    ElevatedCard (
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(16.dp))
    {
        Text(text = card.Question)
        Spacer(Modifier.height(6.dp))
        Text(text = card.Answer)
    }
}