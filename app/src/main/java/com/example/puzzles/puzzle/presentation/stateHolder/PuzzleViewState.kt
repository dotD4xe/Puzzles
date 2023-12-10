package com.example.puzzles.puzzle.presentation.stateHolder

data class PuzzleViewState(
    val word: List<String> = emptyList(),
    val letters: List<String> = emptyList(),
    val done: Boolean = false,
    val puzzle: String = "",
    val secretWord: String = "",
    val wordNotCorrect: Boolean = false,
    val wordCorrect: Boolean = false
)

