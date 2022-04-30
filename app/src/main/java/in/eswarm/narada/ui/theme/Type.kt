package `in`.eswarm.narada.ui.theme

import `in`.eswarm.narada.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val firaCode = FontFamily(
    Font(R.font.firacode_light, FontWeight.Light),
    Font(R.font.firacode_regular, FontWeight.Normal),
    Font(R.font.firacode_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = firaCode,
    body1 = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)