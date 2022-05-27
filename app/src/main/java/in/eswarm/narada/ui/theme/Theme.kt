package `in`.eswarm.narada.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*
private val DarkColorPalette = darkColors(
    primary = biscuitColor,
    primaryVariant = biscuitColor,
    secondary = redSecondary,
    background = blueBackground,
    onBackground = Color.White,
    onSurface = Color.White,
    onSecondary = Color.White,
    onPrimary = Color.White
)

 */

private val ColorPalette = darkColors(
    primary = greenConsole,
    primaryVariant = greenConsole,
    secondary = redSecondary,
    background = blueBackground,
    surface = blueBackground,
    onBackground = Color.White,
    onSurface = Color.White,
    onSecondary = Color.White,
    onPrimary = Color.White
)

@Composable
fun NaradaMQTTBrokerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = ColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}