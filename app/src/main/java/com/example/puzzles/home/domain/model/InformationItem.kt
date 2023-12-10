package com.example.puzzles.home.domain.model

data class InformationItem(
    val complexity: Complexity,
    val quantity: Int,
    val done: Int,
    val level: Int
)

enum class Complexity {
    EASY,
    MEDIUM,
    HARD,
}
