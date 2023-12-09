package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.DISPLAYED_COLUMN_LIMIT
import com.example.puzzles.puzzle.presentation.ITEMS_LETTER_LIMIT
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction

@Composable
fun PuzzleKeyboard(
    letters: List<String>,
    onEvent: (PuzzleViewAction) -> Unit
) {
    val screenWordWidth = (LocalConfiguration.current.screenWidthDp/3).dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(DISPLAYED_COLUMN_LIMIT),
        modifier = Modifier
            .fillMaxWidth()
            .size(screenWordWidth),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        userScrollEnabled = false
    ) {
        items(ITEMS_LETTER_LIMIT) { index ->
            LetterButton(
                modifier = Modifier
                    .background(darkColors.backTertiary, RoundedCornerShape(7.dp))
                    .fillMaxWidth()
                    .aspectRatio(1.0f)
                    .clickable { onEvent(PuzzleViewAction.AddLetter(index)) },
                letter = letters[index]
            )
        }
    }
}