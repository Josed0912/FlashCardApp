package com.example.flashcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.ui.theme.FlashCardAppTheme
import model.Topic
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlashCardApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardApp (modifier: Modifier = Modifier) {

    val topics = rememberSaveable{ mutableListOf<Topic>()}
    val new = rememberSaveable {mutableStateOf(false)}

    val updateNew : (Boolean) -> Unit =
    {
        new.value = it
    }

    val addToList : (Topic) -> Unit = {
        topics.add(it)
    }

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Welcome User!")} )
        },
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = {FloatingActionButton(onClick = {new.value = true}) {
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlashCardAppTheme {
        FlashCardApp()
    }
}



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

@Composable
fun EmptyTopicDisplay(addTopic : (Topic) -> Unit, updateNew : (Boolean) -> Unit){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(16.dp)
    )
    {
        var nameValue by rememberSaveable{mutableStateOf("")}
        TextField(value = nameValue,
            onValueChange = {nameValue = it},
            textStyle = TextStyle(textAlign = TextAlign.Center),
            label = {Text("Enter the name of the topic")}
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

@Composable
fun BottomBar(){
    val selectedIndex = rememberSaveable { mutableIntStateOf(0) }

    BottomNavigation(backgroundColor = Color.Cyan)
    {
        BottomNavigationItem(selected = selectedIndex.value == 0,
            onClick = { selectedIndex.value = 0 },
            icon = { Icon(imageVector = Icons.Default.Home,
                contentDescription = "home",
                tint = if (selectedIndex.value == 0) Color.LightGray else Color.Black)}
            )


        BottomNavigationItem(selected = selectedIndex.value == 1,
            onClick = { selectedIndex.value = 1 },
            icon = { Icon(imageVector = Icons.Default.Person,
                contentDescription = "person",
                tint = if (selectedIndex.value == 1) Color.LightGray else Color.Black) })
    }
}

