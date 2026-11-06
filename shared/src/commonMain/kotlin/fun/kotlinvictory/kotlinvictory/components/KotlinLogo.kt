package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KotlinLogo() {
    val interactionSource = remember { MutableInteractionSource() }

    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.15f else 1.0f,
        animationSpec = tween(durationMillis = 200)
    )
    
    AsyncImage(
        model = "https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=original",
        contentDescription = "KotlinChan logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .sizeIn(maxWidth = 100.dp, maxHeight = 100.dp)
            .padding(10.dp)

            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }

            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )

            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    window.open("https://kotlinlang.org/", target = "KotlinChan website")
                }
            )
    )
}