package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LinkText(text: String, link: String) {
    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.15f else 1.0f,
        animationSpec = tween(durationMillis = 200)
    )

    val interactionSource = remember { MutableInteractionSource() }

    Text(
        text = text,

        Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    window.open(url = link, target = "_blank")
                }
            )

            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )

            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }

            .padding(horizontal = 16.dp),
        textAlign = TextAlign.Center,
        fontSize = 16.sp
    )
}