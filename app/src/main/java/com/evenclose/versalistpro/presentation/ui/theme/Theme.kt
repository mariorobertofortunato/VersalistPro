package com.evenclose.versalistpro.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// TODO provide different colors for the dark theme, at the moment the colors are the same

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    onPrimary = white,
    primaryContainer = primaryContainer,
    onPrimaryContainer = white,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = white,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = white,
    tertiary = Color(0xFF388E3C),
    onTertiary = white,
    tertiaryContainer = Color(0xFF1A237E),
    onTertiaryContainer = white,
    background = background,
    onBackground = white,
    surface = Color(0xFF333333),
    onSurface = white,
    surfaceVariant = Color(0xFF283593),
    onSurfaceVariant = white,
    surfaceTint = Color(0xFF283593),
    inverseSurface = white,
    inverseOnSurface = Color(0xFF333333),
    error = error,
    onError = white,
    errorContainer = errorContainer,
    onErrorContainer = white,
    outline = outline,
    outlineVariant = Color(0xFF283593),
    scrim = Color(0x99000000)
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = white,
    primaryContainer = primaryContainer,
    onPrimaryContainer = white,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = white,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = white,
    tertiary = Color(0xFF388E3C),
    onTertiary = white,
    tertiaryContainer = Color(0xFF1A237E),
    onTertiaryContainer = white,
    background = background,
    onBackground = white,
    surface = Color(0xFF333333),
    onSurface = white,
    surfaceVariant = Color(0xFF283593),
    onSurfaceVariant = white,
    surfaceTint = Color(0xFF283593),
    inverseSurface = white,
    inverseOnSurface = Color(0xFF333333),
    error = error,
    onError = white,
    errorContainer = errorContainer,
    onErrorContainer = white,
    outline = outline,
    outlineVariant = Color(0xFF283593),
    scrim = Color(0x99000000)
)

@Composable
fun VersalistProTheme(
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
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}