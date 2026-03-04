package com.zino.todo.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.zino.todo.core.designsystem.dimension.LocalAppDimens
import com.zino.todo.core.designsystem.dimension.TDimensions

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
//    secondary = PurpleGrey80,
//    tertiary = Pink80,

    primaryContainer = Color(0xFF333333),
    onPrimaryContainer = Color.White,

    secondary = Color(0xFFB3B3B3), // Medium Gray
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF2C2C2C),
    onSecondaryContainer = Color(0xFFE1E1E1),

    tertiary = Color(0xFF4D94FF), // Lighter blue for dark mode readability
    onTertiary = Color.Black,

    background = Color(0xFF121212), // Deep charcoal (better than pure black for OLED)
    surface = Color(0xFF1E1E1E),
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,
//    secondary = PurpleGrey40,
//    tertiary = Pink40,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
    primaryContainer = Color(0xFFE5E5E5), // Soft gray for "Primary" cards
    onPrimaryContainer = Color.Black,

    secondary = Color(0xFF4A4A4A), // Deep Slate
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF0F0F0), // Light subtle gray
    onSecondaryContainer = Color(0xFF1A1A1A),

    tertiary = Color(0xFF0066FF), // A vibrant "Electric Blue" accent
    onTertiary = Color.White,

    background = Color.White,
    surface = Color(0xFFF9F9F9), // Slightly off-white to distinguish from background
    onBackground = Color(0xFF121212),
    onSurface = Color(0xFF121212),

    // Error colors (standard Material Red)
    error = Color(0xFFB00020),
    onError = Color.White
)

@Composable
fun TodoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val dimensions = TDimensions()

    CompositionLocalProvider(LocalAppDimens provides dimensions) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object AppTheme {
    val dimens: TDimensions
        @Composable
        get() = LocalAppDimens.current
}