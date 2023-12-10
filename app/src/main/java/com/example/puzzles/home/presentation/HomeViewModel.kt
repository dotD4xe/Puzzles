package com.example.puzzles.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puzzles.home.domain.model.Complexity
import com.example.puzzles.home.domain.model.InformationItem
import com.example.puzzles.home.presentation.stateHolder.HomeViewAction
import com.example.puzzles.home.presentation.stateHolder.HomeViewEvent
import com.example.puzzles.home.presentation.stateHolder.HomeViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    private val _viewEvent = Channel<HomeViewEvent>()
    val viewEvent = _viewEvent.receiveAsFlow()

    init {
        val item = InformationItem(Complexity.EASY, 22, 4, 5)
        val item1 = InformationItem(Complexity.MEDIUM, 100, 40, 41)
        val item2 = InformationItem(Complexity.HARD, 30, 30, 31)
        val informations = listOf(item, item1, item2)

        val sumDone = informations.sumOf { it.done.toDouble() }
        val sumQuantity = informations.sumOf { it.quantity.toDouble() }
        val completed = ((sumDone / sumQuantity) *  100).toInt()

        _viewState.update {
            viewState.value.copy(
                puzzlesInformation = informations,
                completed = completed
            )
        }
    }

    fun onAction(action: HomeViewAction) {
        when(action) {
            is HomeViewAction.NavigateToPuzzle -> viewModelScope.launch { _viewEvent.send(HomeViewEvent.GoToPuzzle) }
        }
    }

}