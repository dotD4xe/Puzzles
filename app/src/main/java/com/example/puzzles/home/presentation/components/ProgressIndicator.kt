package com.example.puzzles.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Blue
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors

@Preview
@Composable
fun ProgressIndicator() {
    Column {
        LinearProgressIndicator(
            progress = 0.76f,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            color = Blue,
            trackColor = darkColors.backTertiary
        )
        Text(
            text = stringResource(id = R.string.completed_percent, 76),
            color = Color.White,
            textAlign = TextAlign.Center,
            style = Typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .alpha(0.5f)
        )
    }

}