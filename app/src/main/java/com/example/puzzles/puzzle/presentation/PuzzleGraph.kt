package com.example.puzzles.puzzle.presentation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PuzzleScreenRoute = "puzzle"

fun NavGraphBuilder.puzzleScreen(
    onNavigateToHome: () -> Unit,
) {
    composable(PuzzleScreenRoute) {
        val viewModel: PuzzleViewModel = viewModel()

        PuzzleScreen(
            viewState = viewModel.viewState,
            viewEvent = viewModel.viewEvent,
            onAction = viewModel::onAction,
            onCompletedLevel = onNavigateToHome
        )
    }
}
