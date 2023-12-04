package com.example.puzzles.featurePuzzle.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.featurePuzzle.presentation.components.TopAppBarPuzzle

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PuzzleScreen() {
    Scaffold(
        containerColor = darkColors.backPrimary,
        topBar = { TopAppBarPuzzle() },
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {

        }
    }
}