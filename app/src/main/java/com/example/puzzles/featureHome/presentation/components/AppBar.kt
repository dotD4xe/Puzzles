package com.example.puzzles.featureHome.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Typography

@Composable
fun AppBar() {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = Typography.titleLarge,
            text = "Name"
        )
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = stringResource(id = R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(27.dp)
                .clip(CircleShape),
            alignment = Alignment.CenterEnd,
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}