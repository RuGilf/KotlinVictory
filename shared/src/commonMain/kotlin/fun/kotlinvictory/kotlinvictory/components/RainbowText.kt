package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit


@Composable
fun RainbowText(text: String, fontSize: TextUnit) {
    var textWidth by remember { mutableStateOf(1) }

    val transition = rememberInfiniteTransition(label = "rainbow")
    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "gradientOffset"
    )

    val colors = remember {
        listOf(
            Color.Red,
            Color(0xFFFF7F00),
            Color.Yellow,
            Color.Green,
            Color.Cyan,
            Color.Blue,
            Color.Magenta,
            Color.Red
        )
    }

    val offset = progress * textWidth

    Text(
        text = text,
        fontSize = fontSize,
        style = TextStyle(
            brush = Brush.horizontalGradient(
                colors = colors,
                startX = -offset,
                endX = textWidth - offset,
                tileMode = TileMode.Repeated
            )
        ),
        onTextLayout = {
            textWidth = it.size.width.coerceAtLeast(1)
        },
    )
}