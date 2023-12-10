package com.example.puzzles.puzzle.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewEvent
import kotlinx.coroutines.flow.Flow

@Composable
fun PuzzleViewEventHandler(
    viewEvent: Flow<PuzzleViewEvent>,
    onCompletedLevel: () -> Unit,
) {
    LaunchedEffect(Unit) {
        viewEvent.collect {
            when(it) {
                is PuzzleViewEvent.ToHome -> onCompletedLevel()
            }
        }
    }
}