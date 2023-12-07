package com.example.puzzles.home.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.puzzles.core.theme.Green
import com.example.puzzles.core.theme.Orange
import com.example.puzzles.core.theme.Red
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.home.domain.model.Complexity
import com.example.puzzles.home.domain.model.InformationItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemComplexityOfPuzzles(
    info: InformationItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = {  },
                onLongClick = { }
            )
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
                        .alpha(0.5f)
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

            Column {
                Text(
                    text = stringResource(id = R.string.quantity),
                    color = Color.White,
                    style = Typography.bodySmall,
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 7.dp)
                )
                Text(
                    text = info.quantity.toString(),
                    color = Color.White,
                    style = Typography.labelLarge,
                )
            }
            Column {
                Text(
                    text = stringResource(id = R.string.done),
                    color = Color.White,
                    style = Typography.bodySmall,
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 7.dp)
                )
                Text(
                    text = info.done.toString(),
                    color = Color.White,
                    style = Typography.labelLarge,
                )
            }
        }
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
