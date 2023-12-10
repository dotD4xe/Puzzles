package com.example.puzzles.home.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.puzzles.home.presentation.stateHolder.HomeViewEvent
import kotlinx.coroutines.flow.Flow
@Composable
fun HomeViewEventHandler(
    viewEvent: Flow<HomeViewEvent>,
    onPuzzle: () -> Unit,
) {
    LaunchedEffect(Unit) {
        viewEvent.collect {
            when(it) {
                is HomeViewEvent.GoToPuzzle -> onPuzzle()
            }
        }
    }
}