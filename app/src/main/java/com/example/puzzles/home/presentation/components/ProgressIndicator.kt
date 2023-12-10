package com.example.puzzles.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Green
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.home.presentation.TEXT_ALPHA

@Composable
fun ProgressIndicator(completed: Int) {
    Column {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(
                text = stringResource(id = R.string.completed_percent, completed),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                modifier = Modifier.padding(end = 5.dp)
            )

            Text(
                text = stringResource(id = R.string.completed),
                color = Color.White,
                style = Typography.bodySmall,
                modifier = Modifier
                    .alpha(TEXT_ALPHA)
                    .align(Alignment.Bottom)
            )
        }
        LinearProgressIndicator(
            progress = completed.toFloat()/100,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .height(8.dp),
            color = Green,
            trackColor = darkColors.backTertiary
        )
    }

}