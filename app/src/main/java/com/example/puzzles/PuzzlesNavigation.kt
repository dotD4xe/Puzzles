package com.example.puzzles

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.puzzles.home.presentation.HomeScreenRoute
import com.example.puzzles.home.presentation.homeScreen
import com.example.puzzles.home.presentation.navigateToHome
import com.example.puzzles.puzzle.presentation.PuzzleScreenRoute
import com.example.puzzles.puzzle.presentation.puzzleScreen

@Composable
fun PuzzlesNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute
    ) {
        puzzleScreen(
            onNavigateToHome = navController::navigateToHome,
        )
        homeScreen(
            onNavigateToPuzzle = { navController.navigate(PuzzleScreenRoute) }
        )
    }
}
