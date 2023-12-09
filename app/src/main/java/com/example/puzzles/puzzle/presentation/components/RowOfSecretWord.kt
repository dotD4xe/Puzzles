package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.Red
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.DISPLAYED_COLUMN_LIMIT
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction

@Composable
fun RowOfSecretWord(
    secretWord: String,
    word: List<String>,
    wordNotCorrect: Boolean,
    onEvent: (PuzzleViewAction) -> Unit
) {
    var textSize by remember { mutableStateOf(1f) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement
            .spacedBy(
                space = 5.dp,
                alignment = Alignment.CenterHorizontally
            ),
    ) {
        val commonModifier = Modifier.background(darkColors.backSecondary, RoundedCornerShape(7.dp))
        val modifier = if (secretWord.length > DISPLAYED_COLUMN_LIMIT) commonModifier
            .weight(1f)
            .aspectRatio(1.0f)
        else commonModifier
            .width(45.dp)
            .aspectRatio(1.0f)

        repeat(secretWord.length ) { index ->
            Box(
                modifier = modifier
                    .clickable { onEvent(PuzzleViewAction.DeleteLetter(index)) }
                    .border(
                        width = 1.dp,
                        color = if (wordNotCorrect) Red else darkColors.backPrimary,
                        shape = RoundedCornerShape(7.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = word.getOrNull(index) ?: "",
                    color = Color.White,
                    overflow = TextOverflow.Visible,
                    style = Typography.displayLarge.copy(
                        fontSize = Typography.displayLarge.fontSize * textSize
                    ),
                    onTextLayout = { text ->
                        if (text.hasVisualOverflow) textSize *= 0.95f
                    }
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(64.dp))
}