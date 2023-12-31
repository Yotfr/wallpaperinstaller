package ru.yotfr.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class Shape(
    val small: androidx.compose.ui.graphics.Shape = RoundedCornerShape(4.dp),
    val default: androidx.compose.ui.graphics.Shape = RoundedCornerShape(8.dp),
    val large: androidx.compose.ui.graphics.Shape = RoundedCornerShape(12.dp)
)

val LocalShapes = staticCompositionLocalOf { Shape() }