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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.puzzles.R

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
            text = "Name"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(id = R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            alignment = Alignment.CenterEnd
        )
    }
}