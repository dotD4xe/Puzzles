package com.example.puzzles.featurePuzzle.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Typography

@Preview
@Composable
fun TopAppBarPuzzle() {
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
                .align(Alignment.CenterStart),
//            colorFilter = ColorFilter.tint(Color.White)
        )

        Box(
            modifier = Modifier
                .background(Color(49, 194, 182), RoundedCornerShape(7.dp))
                .align(Alignment.Center)
        ) {
            Text(
                text = "Загадка",
                color = Color.White,
                style = Typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .padding(start = 12.dp, end = 12.dp)
            )
        }

    }
}