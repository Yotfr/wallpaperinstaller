package ru.yotfr.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF3C691B)
val light_onPrimary = Color(0xFFFFFFFF)
val light_primaryContainer = Color(0xFFBCF293)
val light_onPrimaryContainer = Color(0xFF0B2000)
val light_secondary = Color(0xFF56624B)
val light_onSecondary = Color(0xFFFFFFFF)
val light_secondaryContainer = Color(0xFFDAE7CA)
val light_onSecondaryContainer = Color(0xFF141E0C)
val light_tertiary = Color(0xFF386665)
val light_onTertiary = Color(0xFFFFFFFF)
val light_tertiaryContainer = Color(0xFFBBECEA)
val light_onTertiaryContainer = Color(0xFF002020)
val light_error = Color(0xFFBA1A1A)
val light_errorContainer = Color(0xFFFFDAD6)
val light_onError = Color(0xFFFFFFFF)
val light_onErrorContainer = Color(0xFF410002)
val light_background = Color(0xFFFDFDF5)
val light_onBackground = Color(0xFF1A1C18)
val light_surface = Color(0xFFFDFDF5)
val light_onSurface = Color(0xFF1A1C18)
val light_surfaceVariant = Color(0xFFE0E4D6)
val light_onSurfaceVariant = Color(0xFF44483E)
val light_outline = Color(0xFF74796D)
val light_inverseOnSurface = Color(0xFFF1F1EA)
val light_inverseSurface = Color(0xFF2F312C)
val light_inversePrimary = Color(0xFFA1D57A)
val light_shadow = Color(0xFF000000)
val light_surfaceTint = Color(0xFF3C691B)
val light_outlineVariant = Color(0xFFC4C8BB)
val light_scrim = Color(0xFF000000)

val dark_primary = Color(0xFFA1D57A)
val dark_onPrimary = Color(0xFF173800)
val dark_primaryContainer = Color(0xFF255102)
val dark_onPrimaryContainer = Color(0xFFBCF293)
val dark_secondary = Color(0xFFBECBAF)
val dark_onSecondary = Color(0xFF293420)
val dark_secondaryContainer = Color(0xFF3F4A35)
val dark_onSecondaryContainer = Color(0xFFDAE7CA)
val dark_tertiary = Color(0xFFA0CFCE)
val dark_onTertiary = Color(0xFF003737)
val dark_tertiaryContainer = Color(0xFF1E4E4D)
val dark_onTertiaryContainer = Color(0xFFBBECEA)
val dark_error = Color(0xFFFFB4AB)
val dark_errorContainer = Color(0xFF93000A)
val dark_onError = Color(0xFF690005)
val dark_onErrorContainer = Color(0xFFFFDAD6)
val dark_background = Color(0xFF1A1C18)
val dark_onBackground = Color(0xFFE3E3DC)
val dark_surface = Color(0xFF1A1C18)
val dark_onSurface = Color(0xFFE3E3DC)
val dark_surfaceVariant = Color(0xFF44483E)
val dark_onSurfaceVariant = Color(0xFFC4C8BB)
val dark_outline = Color(0xFF8E9286)
val dark_inverseOnSurface = Color(0xFF1A1C18)
val dark_inverseSurface = Color(0xFFE3E3DC)
val dark_inversePrimary = Color(0xFF3C691B)
val dark_shadow = Color(0xFF000000)
val dark_surfaceTint = Color(0xFFA1D57A)
val dark_outlineVariant = Color(0xFF44483E)
val dark_scrim = Color(0xFF000000)


val seed = Color(0xFF3D6A1C)


val lightColors = lightColorScheme(
    primary = light_primary,
    onPrimary = light_onPrimary,
    primaryContainer = light_primaryContainer,
    onPrimaryContainer = light_onPrimaryContainer,
    secondary = light_secondary,
    onSecondary = light_onSecondary,
    secondaryContainer = light_secondaryContainer,
    onSecondaryContainer = light_onSecondaryContainer,
    tertiary = light_tertiary,
    onTertiary = light_onTertiary,
    tertiaryContainer = light_tertiaryContainer,
    onTertiaryContainer = light_onTertiaryContainer,
    error = light_error,
    errorContainer = light_errorContainer,
    onError = light_onError,
    onErrorContainer = light_onErrorContainer,
    background = light_background,
    onBackground = light_onBackground,
    surface = light_surface,
    onSurface = light_onSurface,
    surfaceVariant = light_surfaceVariant,
    onSurfaceVariant = light_onSurfaceVariant,
    outline = light_outline,
    inverseOnSurface = light_inverseOnSurface,
    inverseSurface = light_inverseSurface,
    inversePrimary = light_inversePrimary,
    surfaceTint = light_surfaceTint,
    outlineVariant = light_outlineVariant,
    scrim = light_scrim,
)


val darkColors = darkColorScheme(
    primary = dark_primary,
    onPrimary = dark_onPrimary,
    primaryContainer = dark_primaryContainer,
    onPrimaryContainer = dark_onPrimaryContainer,
    secondary = dark_secondary,
    onSecondary = dark_onSecondary,
    secondaryContainer = dark_secondaryContainer,
    onSecondaryContainer = dark_onSecondaryContainer,
    tertiary = dark_tertiary,
    onTertiary =  dark_onTertiary,
    tertiaryContainer =  dark_tertiaryContainer,
    onTertiaryContainer =  dark_onTertiaryContainer,
    error =  dark_error,
    errorContainer =  dark_errorContainer,
    onError =  dark_onError,
    onErrorContainer =  dark_onErrorContainer,
    background =  dark_background,
    onBackground =  dark_onBackground,
    surface =  dark_surface,
    onSurface =  dark_onSurface,
    surfaceVariant =  dark_surfaceVariant,
    onSurfaceVariant =  dark_onSurfaceVariant,
    outline =  dark_outline,
    inverseOnSurface =  dark_inverseOnSurface,
    inverseSurface =  dark_inverseSurface,
    inversePrimary =  dark_inversePrimary,
    surfaceTint =  dark_surfaceTint,
    outlineVariant =  dark_outlineVariant,
    scrim =  dark_scrim,
)

val whiteColor = Color(0xFFFFFFFF)
val blackColor = Color(0xFF000000)
val placeHolderColor = Color(0xFF44483E)

@Immutable
data class ExtraColors(
    val onWallpaperText: Color,
    val wallpaperEndGradient: Color,
    val placeHolderColor: Color
)

val LocalExtraColors = staticCompositionLocalOf {
    ExtraColors(
        onWallpaperText = Color.Unspecified,
        wallpaperEndGradient = Color.Unspecified,
        placeHolderColor = Color.Unspecified
    )
}
