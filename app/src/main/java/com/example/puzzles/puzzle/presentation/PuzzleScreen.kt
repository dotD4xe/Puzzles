package com.example.puzzles.puzzle.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.components.PuzzleDescription
import com.example.puzzles.puzzle.presentation.components.PuzzleKeyboard
import com.example.puzzles.puzzle.presentation.components.PuzzleViewEventHandler
import com.example.puzzles.puzzle.presentation.components.RowOfSecretWord
import com.example.puzzles.puzzle.presentation.components.SuccessDialog
import com.example.puzzles.puzzle.presentation.components.TopAppBarPuzzle
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewEvent
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

const val DISPLAYED_COLUMN_LIMIT = 6
const val ITEMS_LETTER_LIMIT = 12

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzleScreen(
    viewState: StateFlow<PuzzleViewState>,
    viewEvent: Flow<PuzzleViewEvent>,
    onAction: (PuzzleViewAction) -> Unit,
    onCompletedLevel: () -> Unit,
) {
    val viewStateUi by viewState.collectAsStateWithLifecycle()

    PuzzleViewEventHandler(viewEvent, onCompletedLevel)

    SuccessDialog(viewStateUi.wordCorrect, onAction)

    Scaffold(
        containerColor = darkColors.backPrimary,
        topBar = { TopAppBarPuzzle(onAction) },
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {

            item {
                PuzzleDescription(description = viewStateUi.puzzle)
            }

            item {
                RowOfSecretWord(
                    secretWord = viewStateUi.secretWord,
                    word = viewStateUi.word,
                    wordNotCorrect = viewStateUi.wordNotCorrect,
                    onEvent = onAction
                )
            }

            item {
                PuzzleKeyboard(
                    letters = viewStateUi.letters,
                    onEvent = onAction
                )
            }
        }
    }
}