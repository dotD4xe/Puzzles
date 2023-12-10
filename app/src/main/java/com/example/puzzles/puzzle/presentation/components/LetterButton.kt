package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.layout.Box

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.puzzles.core.theme.Typography


@Composable
fun LetterButton(modifier: Modifier, letter: String) {

    var multiplier by remember { mutableStateOf(1f) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter,
            color = Color.White,
            overflow = TextOverflow.Visible,
            style = Typography.displayLarge.copy(
                fontSize = Typography.displayLarge.fontSize * multiplier
            ),
            onTextLayout = {
                if (it.hasVisualOverflow) {
                    multiplier *= 0.95f
                }
            }
        )
    }
}