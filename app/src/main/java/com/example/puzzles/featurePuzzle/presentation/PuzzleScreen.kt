package com.example.puzzles.featurePuzzle.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.featurePuzzle.presentation.components.LetterButton
import com.example.puzzles.featurePuzzle.presentation.components.TopAppBarPuzzle

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PuzzleScreen() {

    val screenWidth = LocalConfiguration.current.screenWidthDp / 3f

    Scaffold(
        containerColor = darkColors.backPrimary,
        topBar = { TopAppBarPuzzle() },
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {

            item {
                Spacer(modifier = Modifier.height(32.dp))
                Card (
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = darkColors.backSecondary,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "В синем небе светляки — Не дотянешь к ним руки. А один большой светляк Изогнулся, как червяк.",
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(6),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(screenWidth.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = false
                ) {
                    items(12) { index ->
                        LetterButton(
                            modifier = Modifier
                                .background(darkColors.backTertiary, RoundedCornerShape(7.dp))
                                .fillMaxWidth()
                                .aspectRatio(1.0f)
                        )
                    }
                }
            }
        }
    }
}