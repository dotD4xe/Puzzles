package com.example.puzzles.home.presentation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val HomeScreenRoute = "home"

fun NavController.navigateToHome() {
    this.navigate((HomeScreenRoute)) {
        popUpTo(0)
        launchSingleTop = true
    }
}

fun NavGraphBuilder.homeScreen(
    onNavigateToPuzzle: () -> Unit,
) {
    composable(HomeScreenRoute) {
        val viewModel: HomeViewModel = viewModel()

        HomeScreen(
            viewState = viewModel.viewState,
            viewEvent = viewModel.viewEvent,
            onAction = viewModel::onAction,
            onPuzzle = onNavigateToPuzzle
        )
    }
}