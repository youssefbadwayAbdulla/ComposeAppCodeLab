package com.example.composeapp.section_one.codelabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.Purple40
import com.example.composeapp.ui.theme.Purple80

@Composable
fun GradientButtonLogin(value: String) {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .fillMaxWidth()
            .background(brush = Brush.horizontalGradient(listOf(Purple40, Purple80))),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        onClick = {}
    ) {
        Text(text = value)
    }
}

@Preview(name = "Light Mode")
@Composable
fun PreviewGradientButtonLogin() {
    ComposeAppTheme {
    GradientButtonLogin(value = "Login")
    }
}
