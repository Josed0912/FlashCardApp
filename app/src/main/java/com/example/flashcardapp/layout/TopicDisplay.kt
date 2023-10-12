package com.example.flashcardapp.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.model.Topic

@Composable
fun TopicDisplay(topic : Topic, modifier : Modifier = Modifier,)
{
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier.padding(16.dp)
    ){

            Text(
                text = topic.Name,
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Left
            )


        Box(Modifier.padding(10.dp).fillMaxWidth()){
            Text(
                text = "FlashCards: ${topic.FlashCards.count()}",
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Icon(painter = painterResource(id = topic.Icon.Source),
            contentDescription = "icon",
            modifier = Modifier.size(24.dp).align(Alignment.CenterEnd))
        }




    }
}