package com.example.composeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScoreSection(
    score: Int,
    countCallback: () -> Unit
) {
    Column {
        Text(text = "Score $score")
        Button(onClick = {
            countCallback()
        }) {
            Text(text = "Add Point")
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScoreSectionPreview() {
    var score by remember { mutableStateOf(0) }

    ScoreSection(score = score, {score+=1})
}