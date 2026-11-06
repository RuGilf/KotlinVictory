package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinvictory.shared.generated.resources.KotlinChan
import kotlinvictory.shared.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import org.w3c.dom.Text

@Composable
fun KotlinVictory() {
    Row(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Column {
            RainbowText("2026 - год победы котлин", 40.sp)
            Row {
                Text("и так уже: ", fontSize = 40.sp)
                VictoryTimer(40.sp)
                Text(" лет", fontSize = 40.sp)
            }
        }

        Image(
            painter = painterResource(Res.drawable.KotlinChan),
            contentDescription = "Kotlin dev",

            modifier = Modifier
                .size(600.dp),
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.Fit
        )
    }
}