package com.example.puzzles.puzzle.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puzzles.core.theme.Red
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.puzzle.presentation.components.LetterButton
import com.example.puzzles.puzzle.presentation.components.TopAppBarPuzzle
import com.example.puzzles.puzzle.presentation.stateHolder.PuzzleViewAction

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PuzzleScreen(
    viewModel: PuzzleViewModel = viewModel(),
//    viewState: PuzzleViewState,
//    viewAction: (PuzzleViewAction) -> Unit,
) {
    var multiplier by remember { mutableStateOf(1f) }
    val screenWordWidth = (LocalConfiguration.current.screenWidthDp/3).dp

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

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
                        text = viewState.puzzle,
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
                    val commonModifier = Modifier.background(darkColors.backSecondary, RoundedCornerShape(7.dp))
                    val modifier = if (viewState.secretWord.length > 6) commonModifier.weight(1f).aspectRatio(1.0f)
                    else commonModifier.width(45.dp).aspectRatio(1.0f)

                    repeat(viewState.secretWord.length ) { index ->
                        Box(
                            modifier = modifier
                                .clickable { viewModel.onAction(PuzzleViewAction.DeleteLetter(index)) }
                                .border(
                                    width = 1.dp,
                                    color = if (viewState.wordNotCorrect) Red else darkColors.backPrimary,
                                    shape = RoundedCornerShape(7.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = viewState.word.getOrNull(index) ?: "",
                                color = Color.White,
                                overflow = TextOverflow.Visible,
                                style = Typography.titleLarge.copy(
                                    fontSize = Typography.titleLarge.fontSize * multiplier
                                ),
                                onTextLayout = { text ->
                                    if (text.hasVisualOverflow) multiplier *= 0.95f
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
                        .size(screenWordWidth),
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
                                .clickable { viewModel.onAction(PuzzleViewAction.AddLetter(index)) },
                            letter = viewState.letters[index]
                        )
                    }
                }
            }
        }
    }
}