package com.example.puzzles.puzzle.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.darkColors

@Composable
fun PuzzleDescription(description: String) {
    Spacer(modifier = Modifier.height(32.dp))
    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = darkColors.backSecondary,
            contentColor = Color.White
        ),
    ) {
        Text(
            text = description,
            modifier = Modifier
                .padding(16.dp)
        )
    }
    Spacer(modifier = Modifier.height(32.dp))
}