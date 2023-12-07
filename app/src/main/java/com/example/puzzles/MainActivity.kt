package com.example.puzzles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puzzles.core.theme.PuzzlesTheme
import com.example.puzzles.home.presentation.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuzzlesTheme {
                HomeScreen()
            }
        }
    }
}