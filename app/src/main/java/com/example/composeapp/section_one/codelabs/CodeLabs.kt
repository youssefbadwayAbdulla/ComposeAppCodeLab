package com.example.composeapp.section_one.codelabs

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

@Preview(name = "Light Mode")
@Composable
fun PreviewGreeting() {
    ComposeAppTheme {
        Surface {
            Greeting("Ali")
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expended by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expended )48.dp else 0.dp, label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(
              onClick = { expended = !expended },
            ) {
                Text(
                    text = if (expended) "Show Less" else "Show More",
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }

    }
}

