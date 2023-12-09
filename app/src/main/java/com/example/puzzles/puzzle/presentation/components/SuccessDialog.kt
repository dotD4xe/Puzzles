package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.puzzles.R
import com.example.puzzles.core.theme.Blue
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors

@Composable
fun SuccessDialog(
    wordCorrect: Boolean
) {
    if (wordCorrect) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))
        val progress by animateLottieCompositionAsState(
            composition,
            iterations = 1,
            isPlaying = true,
            speed = 0.8f,
            restartOnPlay = false
        )
        AlertDialog(
            title = {
                Text(
                    text = stringResource(id = R.string.mission_complete),
                    color = Color.White,
                    style = Typography.titleLarge
                )
            },
            onDismissRequest = {},
            confirmButton = {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = stringResource(id = R.string.new_mystery))
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(7.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = stringResource(id = R.string.home))
                }
            },
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),
            containerColor = darkColors.backPrimary,
            icon = {
                LottieAnimation(
                    composition,
                    progress,
                    modifier = Modifier.size(100.dp)
                )
            },
        )
    }
}