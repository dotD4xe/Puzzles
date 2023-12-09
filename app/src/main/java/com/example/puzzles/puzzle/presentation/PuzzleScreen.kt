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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.components.PuzzleDescription
import com.example.puzzles.puzzle.presentation.components.PuzzleKeyboard
import com.example.puzzles.puzzle.presentation.components.RowOfSecretWord
import com.example.puzzles.puzzle.presentation.components.SuccessDialog
import com.example.puzzles.puzzle.presentation.components.TopAppBarPuzzle

const val DISPLAYED_COLUMN_LIMIT = 6
const val ITEMS_LETTER_LIMIT = 12

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PuzzleScreen(
    viewModel: PuzzleViewModel = viewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    SuccessDialog(viewState.wordCorrect)

    Scaffold(
        containerColor = darkColors.backPrimary,
        topBar = { TopAppBarPuzzle() },
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {

            item {
                PuzzleDescription(description = viewState.puzzle)
            }

            item {
                RowOfSecretWord(
                    secretWord = viewState.secretWord,
                    word = viewState.word,
                    wordNotCorrect = viewState.wordNotCorrect,
                    onEvent = viewModel::onAction
                )
            }

            item {
                PuzzleKeyboard(
                    letters = viewState.letters,
                    onEvent = viewModel::onAction
                )
            }
        }
    }
}