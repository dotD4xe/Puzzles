package com.example.puzzles.featureHome.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.puzzles.featureHome.presentation.components.AppBar

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color(26, 29, 38),
        topBar = { AppBar() }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = ""
        )
    }
}

