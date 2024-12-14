package com.example.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.ui.theme.HabitTrackerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))}
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf("Hello Android!") }

    Column(modifier = modifier.padding(16.dp)){
        Text(
            text = textState.value,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                textState.value = "Habit Added!"
            }
        ) {
            Text(text = "Add Habit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HabitTrackerTheme {
        Greeting()
    }
}