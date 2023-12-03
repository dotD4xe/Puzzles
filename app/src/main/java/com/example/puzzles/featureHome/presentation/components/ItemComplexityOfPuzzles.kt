package com.example.puzzles.featureHome.presentation.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.featureHome.domain.model.Complexity
import com.example.puzzles.featureHome.domain.model.InformationItem

@Composable
fun ItemComplexityOfPuzzles(
    info: InformationItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(37, 40, 51),
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
                text = "Puzzles",
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
                    text = "complexity",
                    color = Color.White,
                    style = Typography.bodySmall,
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 7.dp)
                )
                Text(
                    text = when(info.complexity) {
                        Complexity.EASY -> "Easy"
                        Complexity.MEDIUM -> "Medium"
                        else -> "Hard"
                    },
                    color = when(info.complexity) {
                        Complexity.EASY -> Color(102, 204, 153)
                        Complexity.MEDIUM -> Color(255, 153, 0)
                        else -> Color(255, 102, 102)
                    },
                    style = Typography.labelLarge,
                )
            }

            Column {
                Text(
                    text = "Quantity",
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
                    text = "Done",
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
                when(complexity) {
                    Complexity.EASY -> Color(102, 204, 153)
                    Complexity.MEDIUM -> Color(255, 153, 0)
                    else -> Color(255, 102, 102)
                }
            )
    )
}
