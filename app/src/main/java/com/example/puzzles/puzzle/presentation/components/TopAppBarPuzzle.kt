package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction

@Composable
fun TopAppBarPuzzle(
    onAction: (PuzzleViewAction) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = "Back",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable { onAction(PuzzleViewAction.ToHome) },
        )

        Box(
            modifier = Modifier
                .background(darkColors.puzzleLabel, RoundedCornerShape(7.dp))
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.puzzle),
                color = Color.White,
                style = Typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .padding(start = 12.dp, end = 12.dp)
            )
        }

    }
}