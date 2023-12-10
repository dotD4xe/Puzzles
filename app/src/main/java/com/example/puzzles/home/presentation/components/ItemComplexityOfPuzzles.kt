package com.example.puzzles.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Blue
import com.example.puzzles.core.theme.Green
import com.example.puzzles.core.theme.Orange
import com.example.puzzles.core.theme.Red
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.home.domain.model.Complexity
import com.example.puzzles.home.domain.model.InformationItem
import com.example.puzzles.home.presentation.TEXT_ALPHA
import com.example.puzzles.home.presentation.stateHolder.HomeViewAction

@Composable
fun ItemComplexityOfPuzzles(
    info: InformationItem,
    onAction: (HomeViewAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = darkColors.backSecondary,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                style = Typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterVertically)
            )
            GreenCircle(info.complexity)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.complexity),
                    color = Color.White,
                    style = Typography.bodySmall,
                    modifier = Modifier
                        .alpha(TEXT_ALPHA)
                        .padding(bottom = 7.dp)
                )
                Text(
                    text = when(info.complexity) {
                        Complexity.EASY -> stringResource(id = R.string.difficulty_level_easy)
                        Complexity.MEDIUM -> stringResource(id = R.string.difficulty_level_medium)
                        else -> stringResource(id = R.string.difficulty_level_hard)
                    },
                    color = when(info.complexity) {
                        Complexity.EASY -> Green
                        Complexity.MEDIUM -> Orange
                        else -> Red
                    },
                    style = Typography.labelLarge,
                )
            }
            InfoInCounting(stringResource(id = R.string.quantity), info.quantity)

            InfoInCounting(stringResource(id = R.string.done), info.done)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "${info.level}",
                color = Color.White,
                style = Typography.titleLarge,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .align(Alignment.Bottom)
            )

            Text(
                text = stringResource(id = R.string.level),
                color = Color.White,
                style = Typography.bodySmall,
                modifier = Modifier
                    .alpha(TEXT_ALPHA)
                    .align(Alignment.Bottom)
            )

            Button(
                onClick = { onAction(HomeViewAction.NavigateToPuzzle)},
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue,
                    contentColor = Color.White
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.continue_next),
                )
            }
        }
    }
}

@Composable
fun InfoInCounting(text: String, count: Int) {
    Column {
        Text(
            text = text,
            color = Color.White,
            style = Typography.bodySmall,
            modifier = Modifier
                .alpha(TEXT_ALPHA)
                .padding(bottom = 7.dp)
        )
        Text(
            text = count.toString(),
            color = Color.White,
            style = Typography.labelLarge,
        )
    }
}

@Composable
fun GreenCircle(complexity: Complexity){
    Box(
        modifier = Modifier
            .size(10.dp)
            .clip(shape = CircleShape)
            .background(
                when (complexity) {
                    Complexity.EASY -> Green
                    Complexity.MEDIUM -> Orange
                    else -> Red
                }
            )
    )
}
