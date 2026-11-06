package `fun`.kotlinvictory.kotlinvictory.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `fun`.kotlinvictory.kotlinvictory.components.KotlinLogo

@Composable
fun SiteHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        KotlinLogo()
        RainbowText("КотлинПобеда.fun", 60.sp)
        Row(
            Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.End,

        ) {
            LinkText("GitHub", "https://github.com/RuGilf")
            LinkText("Репозиторий сайта", "") // TODO Добавить ссылку на репо
        }
    }
}