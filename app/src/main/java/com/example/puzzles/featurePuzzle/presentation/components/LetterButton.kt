package com.example.puzzles.featurePuzzle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors


@Composable
fun LetterButton(modifier: Modifier, index: Int, list: MutableList<String>) {

    var multiplier by remember { mutableStateOf(1f) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = list[index],
            color = Color.White,
            overflow = TextOverflow.Visible,
            style = Typography.titleLarge.copy(
                fontSize = Typography.titleLarge.fontSize * multiplier
            ),
            onTextLayout = {
                if (it.hasVisualOverflow) {
                    multiplier *= 0.95f
                }
            }
        )
    }
}