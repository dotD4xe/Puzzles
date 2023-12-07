package com.example.puzzles.puzzle.presentation

import androidx.lifecycle.ViewModel
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PuzzleViewModel: ViewModel() {

    private val _viewState = MutableStateFlow(PuzzleViewState())
    val viewState = _viewState.asStateFlow()

    init {
        val secretWord = "BOB"
        val letters = listOf("A", "B", "C", "D", "E", "O", "G", "A", "B", "C", "D", "E", "F")
        val puzzle = "В синем небе светляки — Не дотянешь к ним руки. А один большой светляк Изогнулся, как червяк."
        val done = false

        _viewState.update {
            viewState.value.copy(
                word = List(secretWord.length) { "" },
                letters = letters,
                puzzle = puzzle,
                secretWord = secretWord,
                done = done
            )
        }
    }

    fun onAction(action: PuzzleViewAction) {
        when(action) {
            is PuzzleViewAction.AddLetter -> addLetter(action.indexLetter)
            is PuzzleViewAction.DeleteLetter -> deleteLetter(action.indexLetter)
        }
    }

    private fun deleteLetter(index: Int) {
        val secretLetters = viewState.value.word.toMutableList()
        val keywordLetters = viewState.value.letters.toMutableList()

        val indexOfEmptyPlace = keywordLetters.indexOf("")

        if (indexOfEmptyPlace != -1) {
            keywordLetters[indexOfEmptyPlace] = secretLetters[index]
            secretLetters[index] = ""
            _viewState.update {
                viewState.value.copy(
                    word = secretLetters,
                    letters = keywordLetters,
                )
            }
        }
    }

    private fun addLetter(index: Int) {
        val secretLetters = viewState.value.word.toMutableList()
        val keywordLetters = viewState.value.letters.toMutableList()

        val indexOfEmptyPlace = secretLetters.indexOf("")

        if (indexOfEmptyPlace != -1) {
            secretLetters[indexOfEmptyPlace] = keywordLetters[index]
            keywordLetters[index] = ""
            _viewState.update {
                viewState.value.copy(
                    word = secretLetters,
                    letters = keywordLetters,
                )
            }
        }
    }
}