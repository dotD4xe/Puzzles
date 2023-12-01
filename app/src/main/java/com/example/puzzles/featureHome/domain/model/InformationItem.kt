package com.example.puzzles.featureHome.domain.model

data class InformationItem(
    val complexity: Complexity,
    val quantity: Int,
    val done: Int,
)

enum class Complexity {
    EASY,
    MEDIUM,
    HARD,
}
