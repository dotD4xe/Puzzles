package com.example.puzzles.featurePuzzle.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.featurePuzzle.presentation.components.LetterButton
import com.example.puzzles.featurePuzzle.presentation.components.TopAppBarPuzzle

const val SECRET_WORD = "defa"

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PuzzleScreen() {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val keyWord = (screenWidth/3).dp

    var multiplier by remember { mutableStateOf(1f) }
    var multiplier2 by remember { mutableStateOf(1f) }

    val letterList = remember {
        mutableStateListOf<String>().apply {
            addAll(List(SECRET_WORD.length) { "" })
        }
    }
    val listWord = remember { mutableStateListOf("A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F") }

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
                Row(
                    horizontalArrangement = Arrangement
                        .spacedBy(
                            space = 5.dp,
                            alignment = Alignment.CenterHorizontally
                        ),
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    val commonModifier = Modifier
                        .background(darkColors.backSecondary, RoundedCornerShape(7.dp))

                    val modifier = if (SECRET_WORD.length > 6) commonModifier.weight(1f).aspectRatio(1.0f)
                    else commonModifier.width(45.dp).aspectRatio(1.0f)

                    repeat(SECRET_WORD.length ) { index ->
                        Box(
                            modifier = modifier
                                .clickable {
                                    val indexOfEmptyPlace = listWord.indexOf("")
                                    if (indexOfEmptyPlace != -1) listWord[indexOfEmptyPlace] = letterList[index]
                                    letterList[index] = ""
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = letterList.getOrNull(index) ?: "",
                                color = Color.White,
                                overflow = TextOverflow.Visible,
                                style = Typography.titleLarge.copy(
                                    fontSize = Typography.titleLarge.fontSize * multiplier
                                ),
                                onTextLayout = {
                                    if (it.hasVisualOverflow) multiplier *= 0.95f
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))
            }

            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(6),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(keyWord),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    userScrollEnabled = false
                ) {
                    items(12) { index ->
                        LetterButton(
                            modifier = Modifier
                                .background(darkColors.backTertiary, RoundedCornerShape(7.dp))
                                .fillMaxWidth()
                                .aspectRatio(1.0f)
                                .clickable {
                                    val changeItemIndex = letterList.indexOf("")
                                    if (changeItemIndex != -1) {
                                        letterList[changeItemIndex] = (listWord[index])
                                        listWord[index] = ""
                                    }
                                },
                            index = index,
                            list = listWord
                        )
                    }
                }
            }
        }
    }
}