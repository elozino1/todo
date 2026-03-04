package com.zino.todo.core.designsystem.dimension

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TDimensions(
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingLarge: Dp = 16.dp,
    val screenPadding: Dp = 20.dp,

    // space
    val smallSpace: Dp = 4.dp,
    val mediumSpace: Dp = 8.dp,
    val largeSpace: Dp = 12.dp,
    val xLargeSpace: Dp = 20.dp,
    val xxLargeSpace: Dp = 30.dp,

    //button
    val buttonHeight: Dp = 48.dp,
    val buttonVerticalPadding: Dp = 12.dp,
    val cardElevation: Dp = 4.dp,

    // text
    val smallButtonText: TextUnit = 8.sp,
    val mediumButtonText: TextUnit = 10.sp,
    val largeButtonText: TextUnit = 14.sp,
)

val LocalAppDimens = staticCompositionLocalOf { TDimensions() }