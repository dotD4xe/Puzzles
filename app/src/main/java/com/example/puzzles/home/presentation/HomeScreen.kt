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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.R
import com.example.puzzles.core.theme.Typography
import com.example.puzzles.core.theme.darkColors
import com.example.puzzles.home.domain.model.Complexity
import com.example.puzzles.home.domain.model.InformationItem
import com.example.puzzles.home.presentation.components.TopAppBarHome
import com.example.puzzles.home.presentation.components.ItemComplexityOfPuzzles
import com.example.puzzles.home.presentation.components.ProgressIndicator

val item = InformationItem(Complexity.EASY, 22, 4)
val item1 = InformationItem(Complexity.MEDIUM, 100, 40)
val item2 = InformationItem(Complexity.HARD, 30, 2)
val informations = listOf(item, item1, item2)

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = darkColors.backPrimary,
        topBar = { TopAppBarHome("Daniel") },
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {

            item { ProgressIndicator() }

            item {
                Text(
                    text = stringResource(id = R.string.home_description),
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 32.dp, top = 32.dp),
                    style = Typography.bodyMedium
                )
            }
            items(items = informations) { information ->
                ItemComplexityOfPuzzles(information)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
