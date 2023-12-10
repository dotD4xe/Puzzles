package com.example.puzzles.puzzle.presentation.stateHolder

sealed class PuzzleViewAction {
    data class AddLetter(val indexLetter: Int) : PuzzleViewAction()
    data class DeleteLetter(val indexLetter: Int): PuzzleViewAction()
    object ToHome: PuzzleViewAction()
}

