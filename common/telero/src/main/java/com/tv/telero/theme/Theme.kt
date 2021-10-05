package com.tv.telero.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = TeleroColor.NavyBlue900,
    primaryVariant = TeleroColor.NavyBlueDark,
    secondary = TeleroColor.Pink900,
    secondaryVariant = TeleroColor.PinkDark,
    background = TeleroColor.Grey900,
    surface = TeleroColor.Grey900,
    error = TeleroColor.Red900,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary = TeleroColor.NavyBlue900,
    primaryVariant = TeleroColor.NavyBlueLight,
    secondary = TeleroColor.Pink900,
    secondaryVariant = TeleroColor.PinkLight,
    background = Color.White,
    error = TeleroColor.RedA700,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)

@Composable
fun CoolTvTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
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
