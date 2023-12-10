package com.example.puzzles.home.presentation.stateHolder

import com.example.puzzles.home.domain.model.InformationItem

data class HomeViewState (
    val puzzlesInformation: List<InformationItem> = emptyList(),
    val completed: Int = 0
)