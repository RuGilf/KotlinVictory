package `fun`.kotlinvictory.kotlinvictory

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import `fun`.kotlinvictory.kotlinvictory.components.KotlinVictory
import `fun`.kotlinvictory.kotlinvictory.components.SiteHeader

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            SiteHeader()
            KotlinVictory()
        }
    }
}