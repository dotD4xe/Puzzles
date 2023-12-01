package com.example.puzzles.featureHome.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puzzles.featureHome.domain.model.Complexity
import com.example.puzzles.featureHome.domain.model.InformationItem
import com.example.puzzles.featureHome.presentation.components.AppBar
import com.example.puzzles.featureHome.presentation.components.ItemComplexityOfPuzzles

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color(17, 20, 27, 255),
        topBar = { AppBar() },
    ) {
        val item = InformationItem(Complexity.EASY, 22, 4)
        val item1 = InformationItem(Complexity.MEDIUM, 100, 40)
        val item2 = InformationItem(Complexity.HARD, 30, 2)
        val informations = listOf(item, item1, item2)

        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Come on, Complete Your Mission",
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            LazyColumn {
                items(items = informations) { information ->
                    ItemComplexityOfPuzzles(information)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
