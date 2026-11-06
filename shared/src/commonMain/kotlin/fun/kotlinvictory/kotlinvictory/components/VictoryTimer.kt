package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.isActive
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlinx.datetime.toInstant
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun VictoryTimer(fontSize: TextUnit) {
    val timeZone = remember { TimeZone.of("UTC+3") }

    val start = remember(timeZone) {
        LocalDateTime(2016, 2, 15, 15, 11, 0).toInstant((timeZone))
    }

    var now by remember { mutableStateOf(Clock.System.now()) }

    LaunchedEffect(Unit) {
        while (isActive) {
            now = Clock.System.now()
            delay(16.milliseconds)
        }
    }

    val elapsed = start.periodUntil(now, timeZone)
    val millis = (elapsed.nanoseconds / 1_000_000)
        .toString()
        .padStart(3, '0')

    Text(
        text = "${elapsed.years}.${elapsed.months}${elapsed.days}${elapsed.hours}${elapsed.minutes}${elapsed.seconds}${millis}",
        fontSize = fontSize,
        lineHeight = 40.sp
    )
}