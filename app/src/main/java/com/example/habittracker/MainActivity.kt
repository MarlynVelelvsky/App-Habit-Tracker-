package com.example.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                HabitTracker()
            }
        }
    }
}

@Composable
fun HabitTracker(modifier: Modifier = Modifier) {
    val habits = remember { mutableStateOf(listOf<String>()) }

    Column(modifier = modifier.padding(16.dp)){
        Button(
            onClick = {
                val newHabit = "Habit ${habits.value.size + 1}"
                habits.value = habits.value + newHabit
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Add Habit")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(habits.value) {habit ->
                Text(
                    text = habit,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HabitTrackerPreview() {
    HabitTrackerTheme {
        HabitTracker()
    }
}