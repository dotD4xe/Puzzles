package com.example.puzzles.home.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.puzzles.R
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.home.presentation.components.HomeViewEventHandler
import com.example.puzzles.home.presentation.components.ItemComplexityOfPuzzles
import com.example.puzzles.home.presentation.components.ProgressIndicator
import com.example.puzzles.home.presentation.stateHolder.HomeViewAction
import com.example.puzzles.home.presentation.stateHolder.HomeViewEvent
import com.example.puzzles.home.presentation.stateHolder.HomeViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

const val TEXT_ALPHA = 0.5f

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewState: StateFlow<HomeViewState>,
    viewEvent: Flow<HomeViewEvent>,
    onAction: (HomeViewAction) -> Unit,
    onPuzzle: () -> Unit,
) {

    val viewStateUi by viewState.collectAsStateWithLifecycle()

    HomeViewEventHandler(viewEvent, onPuzzle)

    Scaffold(
        containerColor = darkColors.backPrimary,
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {

            item {
                Text(
                    text = stringResource(id = R.string.home_description),
                    color = Color.White,
                    style = Typography.bodyMedium,
                    modifier = Modifier
                        .padding(top = 32.dp),
                )
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                ProgressIndicator(viewStateUi.completed)
                Spacer(modifier = Modifier.height(32.dp))
            }

            items(items = viewStateUi.puzzlesInformation) { information ->
                ItemComplexityOfPuzzles(information, onAction)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
