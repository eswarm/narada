package `in`.eswarm.narada.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = biscuitColor,
    primaryVariant = biscuitColor,
    secondary = redSecondary,
    background = blueBackground,
    onBackground = Color.White,
    onSurface = Color.Black,
    onSecondary = Color.Black,
    onPrimary = Color.Black
)

private val LightColorPalette = lightColors(
    primary = greenConsole,
    primaryVariant = greenConsole,
    secondary = redSecondary,
    background = blueBackground,
    onBackground = Color.White,
    onSurface = Color.Black,
    onSecondary = Color.Black,
    onPrimary = Color.Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NaradaMQTTBrokerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}