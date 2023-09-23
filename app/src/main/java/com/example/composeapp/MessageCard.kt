package com.example.composeapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

data class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { messages ->
            MessageCard(msg = messages)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(8.dp)) {
        ImageTestSection()
        Spacer(modifier = Modifier.width(8.dp))
        TextTestSection(msg)
    }
}

@Composable
private fun ImageTestSection() {
    Image(
        painter = painterResource(id = R.drawable.me),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
    )
}

@Composable
private fun TextTestSection(msg: Message) {
    // We keep track if the message is expanded or not in this
    // variable
    var isExpanded: Boolean by remember { mutableStateOf(false) }
    // We toggle the isExpanded variable when we click on this Column
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Text(
            text = "${msg.author}!",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(4.dp))
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
            Text(
                text = "${msg.body}!",
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.bodyMedium
            )
        }


    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposeAppTheme {
        Surface {
            Conversation(
                messages = listOf(
                    Message(
                        "Lexi",
                        "Jetpack Compose, it's great!Jetpack Compose, it's great!Jetpack Compose, it's great!"
                    ),
                    Message(
                        "Lexi",
                        "Jetpack Compose, it's greatJetpack Compose, it's greatJetpack Compose, it's greatJetpack Compose, it's great!"
                    ),
                    Message(
                        "Lexi",
                        "Jetpack Compose, it's great!Jetpack Compose, it's great!Jetpack Compose, "
                    ),
                    Message(
                        "Lexi",
                        "Jetpack Compose, it's greatJetpack Compose, it's greatJetpack Compose, it's great!"
                    ),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                    Message("Lexi", "Jetpack Compose, it's great!"),
                )
            )

        }
    }
}



